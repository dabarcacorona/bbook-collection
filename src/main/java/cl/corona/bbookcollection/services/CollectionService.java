package cl.corona.bbookcollection.services;

import cl.corona.bbookcollection.model.BbookEnviaCollection;
import cl.corona.bbookcollection.model.JsonCab;
import cl.corona.bbookcollection.model.JsonDet;
import cl.corona.bbookcollection.model.JsonEnd;
import cl.corona.bbookcollection.repository.BbookEnviaCollectionRepository;
import cl.corona.bbookcollection.utilities.Utility;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CollectionService {

    @Value("${api_url}")
    private String apiurl;

    @Value("${token_uri}")
    private String token;

    @Autowired
    BbookEnviaCollectionRepository updsdirepository;

    private static final Logger LOG = LoggerFactory.getLogger(CollectionService.class);

    public void EnvioDimens(List<BbookEnviaCollection> bbookcollection, String tipo) {

        Gson g = new Gson();
        JsonCab jsoncab = null;
        JsonEnd jsonend = null;
        List<JsonDet> json = new ArrayList<>();
        HttpEntity<String> entity = null;

        try{

            for (BbookEnviaCollection row : bbookcollection) {
                json.add(new JsonDet(String.valueOf(row.getAtrCode()), row.getAtrCodeDesc()));

            }

            jsoncab = new JsonCab(json);
            jsonend = new JsonEnd(jsoncab);

            HttpHeaders headers = new HttpHeaders();
            headers.set("user-agent", "Application");

            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("X-Bbook-Token", token);

            entity = new HttpEntity<String>(g.toJson(jsonend), headers);

        }catch (Exception e) {

            LOG.error("Error al cargar json", e);

        }

        String responses = null;

        try {

            responses = Utility.BulkUpdateApiPoster(entity, apiurl, tipo);

        }catch (Exception e) {

            LOG.error("Error al enviar datos", e);

            responses = "No se pudo informar Marca";
        }

        for (BbookEnviaCollection row : bbookcollection) {
            updsdirepository.updSdiSdivpcmst(row.getId());
        }
    }
}
