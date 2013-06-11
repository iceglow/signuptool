
package ladok.lpw.service.utility.facadeclient;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for provVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="provVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="benamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bskala" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ectsp" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="endaprov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ianv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idatum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="konverterad" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="kurs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poang" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="projarb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urspoang" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "provVO", propOrder = {
    "benamn",
    "benamne",
    "bskala",
    "ectsp",
    "endaprov",
    "ianv",
    "idatum",
    "inst",
    "konverterad",
    "kurs",
    "poang",
    "projarb",
    "prov",
    "urspoang"
})
public class ProvVO {

    protected String benamn;
    protected String benamne;
    protected String bskala;
    protected BigDecimal ectsp;
    protected String endaprov;
    protected String ianv;
    protected String idatum;
    protected String inst;
    protected boolean konverterad;
    protected String kurs;
    protected BigDecimal poang;
    protected String projarb;
    protected String prov;
    protected BigDecimal urspoang;

    /**
     * Gets the value of the benamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBenamn() {
        return benamn;
    }

    /**
     * Sets the value of the benamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBenamn(String value) {
        this.benamn = value;
    }

    /**
     * Gets the value of the benamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBenamne() {
        return benamne;
    }

    /**
     * Sets the value of the benamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBenamne(String value) {
        this.benamne = value;
    }

    /**
     * Gets the value of the bskala property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBskala() {
        return bskala;
    }

    /**
     * Sets the value of the bskala property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBskala(String value) {
        this.bskala = value;
    }

    /**
     * Gets the value of the ectsp property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEctsp() {
        return ectsp;
    }

    /**
     * Sets the value of the ectsp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEctsp(BigDecimal value) {
        this.ectsp = value;
    }

    /**
     * Gets the value of the endaprov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndaprov() {
        return endaprov;
    }

    /**
     * Sets the value of the endaprov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndaprov(String value) {
        this.endaprov = value;
    }

    /**
     * Gets the value of the ianv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIanv() {
        return ianv;
    }

    /**
     * Sets the value of the ianv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIanv(String value) {
        this.ianv = value;
    }

    /**
     * Gets the value of the idatum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdatum() {
        return idatum;
    }

    /**
     * Sets the value of the idatum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdatum(String value) {
        this.idatum = value;
    }

    /**
     * Gets the value of the inst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInst() {
        return inst;
    }

    /**
     * Sets the value of the inst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInst(String value) {
        this.inst = value;
    }

    /**
     * Gets the value of the konverterad property.
     * 
     */
    public boolean isKonverterad() {
        return konverterad;
    }

    /**
     * Sets the value of the konverterad property.
     * 
     */
    public void setKonverterad(boolean value) {
        this.konverterad = value;
    }

    /**
     * Gets the value of the kurs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKurs() {
        return kurs;
    }

    /**
     * Sets the value of the kurs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKurs(String value) {
        this.kurs = value;
    }

    /**
     * Gets the value of the poang property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPoang() {
        return poang;
    }

    /**
     * Sets the value of the poang property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPoang(BigDecimal value) {
        this.poang = value;
    }

    /**
     * Gets the value of the projarb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjarb() {
        return projarb;
    }

    /**
     * Sets the value of the projarb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjarb(String value) {
        this.projarb = value;
    }

    /**
     * Gets the value of the prov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProv() {
        return prov;
    }

    /**
     * Sets the value of the prov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProv(String value) {
        this.prov = value;
    }

    /**
     * Gets the value of the urspoang property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUrspoang() {
        return urspoang;
    }

    /**
     * Sets the value of the urspoang property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUrspoang(BigDecimal value) {
        this.urspoang = value;
    }

}
