package cl.corona.bbookcollection.scheduler;

import cl.corona.bbookcollection.model.BbookEnviaCollection;
import cl.corona.bbookcollection.repository.BbookEnviaCollectionRepository;
import cl.corona.bbookcollection.services.CollectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledTasks {

    private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Autowired
    private CollectionService vendorService;

    private BbookEnviaCollectionRepository bbookenviocollectionrepository;


    @Autowired
    public ScheduledTasks(BbookEnviaCollectionRepository bbookenviocollectionrepository) {
        this.bbookenviocollectionrepository = bbookenviocollectionrepository;
    }

    @Scheduled(cron = "${cron.expression}")
    public void scheduledBbook() throws InterruptedException {
        LOG.info("{} : Generacion periodica para el envio de Colores  - {}",
                dateTimeFormatter.format(LocalDateTime.now()));

        // Date exceptions
        LocalDate today = LocalDate.now();
        int count = 0;
        List<BbookEnviaCollection> Bbookdimens = new ArrayList<>();

        try {
            String statusBrand = "T";
            Bbookdimens = (List<BbookEnviaCollection>) bbookenviocollectionrepository.findAllByTranType("A");

        } catch (InvalidDataAccessResourceUsageException e) {
            LOG.error("{}: Ocurrio un error al momento de rescatar las Marcas: ", e);
            return;
        }

        LOG.info("Cantidad de Marcas para generar: {}", Bbookdimens.size());

        if (Bbookdimens.size() > 0) {
            vendorService.EnvioDimens(Bbookdimens, "A");
        }

        try {
            String statusBrand = "T";
            Bbookdimens = (List<BbookEnviaCollection>) bbookenviocollectionrepository.findAllByTranType("C");

        } catch (InvalidDataAccessResourceUsageException e) {
            LOG.error("{}: Ocurrio un error al momento de rescatar las Marcas: ", e);
            return;
        }

        LOG.info("Cantidad de Marcas para generar: {}", Bbookdimens.size());

        if (Bbookdimens.size() > 0) {
            vendorService.EnvioDimens(Bbookdimens, "C");
        }

        try {
            String statusBrand = "T";
            Bbookdimens = (List<BbookEnviaCollection>) bbookenviocollectionrepository.findAllByTranType("D");

        } catch (InvalidDataAccessResourceUsageException e) {
            LOG.error("{}: Ocurrio un error al momento de rescatar las Marcas: ", e);
            return;
        }

        LOG.info("Cantidad de Marcas para generar: {}", Bbookdimens.size());

        if (Bbookdimens.size() > 0) {
            vendorService.EnvioDimens(Bbookdimens, "D");
        }
    }
}
