
package ladok.lpw.service.register.facadeclient;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for examenVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="examenVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amneBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amneBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gemensamExamina" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hskBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hskBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inrBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inrBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="konvert" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urspoang" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="valuta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "examenVO", propOrder = {
    "amne",
    "amneBenamne",
    "amneBenamns",
    "benamne",
    "benamns",
    "date",
    "endDate",
    "gemensamExamina",
    "hskBenamne",
    "hskBenamns",
    "inr",
    "inrBenamne",
    "inrBenamns",
    "kod",
    "konvert",
    "poang",
    "urspoang",
    "valuta"
})
public class ExamenVO {

    protected String amne;
    protected String amneBenamne;
    protected String amneBenamns;
    protected String benamne;
    protected String benamns;
    protected String date;
    protected String endDate;
    protected boolean gemensamExamina;
    protected String hskBenamne;
    protected String hskBenamns;
    protected String inr;
    protected String inrBenamne;
    protected String inrBenamns;
    protected String kod;
    protected String konvert;
    protected String poang;
    protected BigDecimal urspoang;
    protected String valuta;

    /**
     * Gets the value of the amne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmne() {
        return amne;
    }

    /**
     * Sets the value of the amne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmne(String value) {
        this.amne = value;
    }

    /**
     * Gets the value of the amneBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmneBenamne() {
        return amneBenamne;
    }

    /**
     * Sets the value of the amneBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmneBenamne(String value) {
        this.amneBenamne = value;
    }

    /**
     * Gets the value of the amneBenamns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmneBenamns() {
        return amneBenamns;
    }

    /**
     * Sets the value of the amneBenamns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmneBenamns(String value) {
        this.amneBenamns = value;
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
     * Gets the value of the benamns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBenamns() {
        return benamns;
    }

    /**
     * Sets the value of the benamns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBenamns(String value) {
        this.benamns = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the gemensamExamina property.
     * 
     */
    public boolean isGemensamExamina() {
        return gemensamExamina;
    }

    /**
     * Sets the value of the gemensamExamina property.
     * 
     */
    public void setGemensamExamina(boolean value) {
        this.gemensamExamina = value;
    }

    /**
     * Gets the value of the hskBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHskBenamne() {
        return hskBenamne;
    }

    /**
     * Sets the value of the hskBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHskBenamne(String value) {
        this.hskBenamne = value;
    }

    /**
     * Gets the value of the hskBenamns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHskBenamns() {
        return hskBenamns;
    }

    /**
     * Sets the value of the hskBenamns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHskBenamns(String value) {
        this.hskBenamns = value;
    }

    /**
     * Gets the value of the inr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInr() {
        return inr;
    }

    /**
     * Sets the value of the inr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInr(String value) {
        this.inr = value;
    }

    /**
     * Gets the value of the inrBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInrBenamne() {
        return inrBenamne;
    }

    /**
     * Sets the value of the inrBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInrBenamne(String value) {
        this.inrBenamne = value;
    }

    /**
     * Gets the value of the inrBenamns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInrBenamns() {
        return inrBenamns;
    }

    /**
     * Sets the value of the inrBenamns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInrBenamns(String value) {
        this.inrBenamns = value;
    }

    /**
     * Gets the value of the kod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKod() {
        return kod;
    }

    /**
     * Sets the value of the kod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKod(String value) {
        this.kod = value;
    }

    /**
     * Gets the value of the konvert property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKonvert() {
        return konvert;
    }

    /**
     * Sets the value of the konvert property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKonvert(String value) {
        this.konvert = value;
    }

    /**
     * Gets the value of the poang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoang() {
        return poang;
    }

    /**
     * Sets the value of the poang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoang(String value) {
        this.poang = value;
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

    /**
     * Gets the value of the valuta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValuta() {
        return valuta;
    }

    /**
     * Sets the value of the valuta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValuta(String value) {
        this.valuta = value;
    }

}
