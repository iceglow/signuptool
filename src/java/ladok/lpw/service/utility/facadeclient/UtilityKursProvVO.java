
package ladok.lpw.service.utility.facadeclient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for utilityKursProvVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="utilityKursProvVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="benamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bskala" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="djup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ectsp" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ekurs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="examin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="friv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ianv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idatum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isValid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="kagrpscb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="knivauha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="konvert" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lkurs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messages" type="{http://facadeclient.utility.service.lpw.ladok/}message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nedlagd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poang" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="prov" type="{http://facadeclient.utility.service.lpw.ladok/}provVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="urspoang" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="utbniva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "utilityKursProvVO", propOrder = {
    "benamne",
    "benamns",
    "bskala",
    "djup",
    "ectsp",
    "ekurs",
    "examin",
    "friv",
    "ianv",
    "idatum",
    "inst",
    "isValid",
    "kagrpscb",
    "knivauha",
    "kod",
    "konvert",
    "lkurs",
    "messages",
    "nedlagd",
    "poang",
    "prov",
    "urspoang",
    "utbniva",
    "valid",
    "valuta"
})
public class UtilityKursProvVO {

    protected String benamne;
    protected String benamns;
    protected String bskala;
    protected String djup;
    protected BigDecimal ectsp;
    protected String ekurs;
    protected String examin;
    protected String friv;
    protected String ianv;
    protected String idatum;
    protected String inst;
    protected Boolean isValid;
    protected String kagrpscb;
    protected String knivauha;
    protected String kod;
    protected String konvert;
    protected String lkurs;
    @XmlElement(nillable = true)
    protected List<Message> messages;
    protected String nedlagd;
    protected BigDecimal poang;
    @XmlElement(nillable = true)
    protected List<ProvVO> prov;
    protected BigDecimal urspoang;
    protected String utbniva;
    protected boolean valid;
    protected String valuta;

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
     * Gets the value of the djup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDjup() {
        return djup;
    }

    /**
     * Sets the value of the djup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDjup(String value) {
        this.djup = value;
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
     * Gets the value of the ekurs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEkurs() {
        return ekurs;
    }

    /**
     * Sets the value of the ekurs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEkurs(String value) {
        this.ekurs = value;
    }

    /**
     * Gets the value of the examin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamin() {
        return examin;
    }

    /**
     * Sets the value of the examin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamin(String value) {
        this.examin = value;
    }

    /**
     * Gets the value of the friv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFriv() {
        return friv;
    }

    /**
     * Sets the value of the friv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFriv(String value) {
        this.friv = value;
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
     * Gets the value of the isValid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsValid() {
        return isValid;
    }

    /**
     * Sets the value of the isValid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsValid(Boolean value) {
        this.isValid = value;
    }

    /**
     * Gets the value of the kagrpscb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKagrpscb() {
        return kagrpscb;
    }

    /**
     * Sets the value of the kagrpscb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKagrpscb(String value) {
        this.kagrpscb = value;
    }

    /**
     * Gets the value of the knivauha property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKnivauha() {
        return knivauha;
    }

    /**
     * Sets the value of the knivauha property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKnivauha(String value) {
        this.knivauha = value;
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
     * Gets the value of the lkurs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLkurs() {
        return lkurs;
    }

    /**
     * Sets the value of the lkurs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLkurs(String value) {
        this.lkurs = value;
    }

    /**
     * Gets the value of the messages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Message }
     * 
     * 
     */
    public List<Message> getMessages() {
        if (messages == null) {
            messages = new ArrayList<Message>();
        }
        return this.messages;
    }

    /**
     * Gets the value of the nedlagd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNedlagd() {
        return nedlagd;
    }

    /**
     * Sets the value of the nedlagd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNedlagd(String value) {
        this.nedlagd = value;
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
     * Gets the value of the prov property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prov property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProv().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProvVO }
     * 
     * 
     */
    public List<ProvVO> getProv() {
        if (prov == null) {
            prov = new ArrayList<ProvVO>();
        }
        return this.prov;
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
     * Gets the value of the utbniva property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtbniva() {
        return utbniva;
    }

    /**
     * Sets the value of the utbniva property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtbniva(String value) {
        this.utbniva = value;
    }

    /**
     * Gets the value of the valid property.
     * 
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * Sets the value of the valid property.
     * 
     */
    public void setValid(boolean value) {
        this.valid = value;
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
