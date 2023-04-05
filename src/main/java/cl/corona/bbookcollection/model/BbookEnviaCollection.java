package cl.corona.bbookcollection.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bbook_enviocom")
public class BbookEnviaCollection {

    @Id
    @Column(name = "idd", columnDefinition = "varchar2(100)")
    private String id;

    @Column(name = "atr_code", columnDefinition = "number(20)")
    private Long atrCode;

    @Column(name = "atr_code_desc", columnDefinition = "varchar2(50)")
    protected String atrCodeDesc;

    @Column(name = "inactive", columnDefinition = "varchar2(10)")
    protected String inactive;

    @Column(name = "tran_type", columnDefinition = "varchar2(50)")
    protected String tranType;


    public BbookEnviaCollection() {
        super();
    }

    public BbookEnviaCollection(String id, Long atrCode, String atrCodeDesc, String inactive, String tranType) {
        super();
        this.id = id;
        this.atrCode = atrCode;
        this.atrCodeDesc = atrCodeDesc;
        this.inactive = inactive;
        this.tranType = tranType;
    }

    @Override
    public String toString() {
        return "BbookEnviaCollection{" +
                "id='" + id + '\'' +
                ", atrCode=" + atrCode +
                ", atrCodeDesc='" + atrCodeDesc + '\'' +
                ", inactive='" + inactive + '\'' +
                ", tranType='" + tranType + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getAtrCode() {
        return atrCode;
    }

    public void setAtrCode(Long atrCode) {
        this.atrCode = atrCode;
    }

    public String getAtrCodeDesc() {
        return atrCodeDesc;
    }

    public void setAtrCodeDesc(String atrCodeDesc) {
        this.atrCodeDesc = atrCodeDesc;
    }

    public String getInactive() {
        return inactive;
    }

    public void setInactive(String inactive) {
        this.inactive = inactive;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }
}

