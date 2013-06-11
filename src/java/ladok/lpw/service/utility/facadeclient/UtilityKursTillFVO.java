
package ladok.lpw.service.utility.facadeclient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for utilityKursTillFVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="utilityKursTillFVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="antalord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="antalres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dep1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dep2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ffgpoang" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="kod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="konvert" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kurskod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kursomg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kurstakt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kurstid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kurstyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lok1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lok2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messages" type="{http://facadeclient.utility.service.lpw.ladok/}message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plantal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="slutv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="undform" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "utilityKursTillFVO", propOrder = {
    "antalord",
    "antalres",
    "dep1",
    "dep2",
    "ffgpoang",
    "kod",
    "konvert",
    "kurskod",
    "kursomg",
    "kurstakt",
    "kurstid",
    "kurstyp",
    "lok1",
    "lok2",
    "messages",
    "ort",
    "plantal",
    "slutv",
    "startter",
    "startv",
    "undform",
    "valid",
    "valuta"
})
public class UtilityKursTillFVO {

    protected String antalord;
    protected String antalres;
    protected String dep1;
    protected String dep2;
    protected BigDecimal ffgpoang;
    protected String kod;
    protected String konvert;
    protected String kurskod;
    protected String kursomg;
    protected String kurstakt;
    protected String kurstid;
    protected String kurstyp;
    protected String lok1;
    protected String lok2;
    @XmlElement(nillable = true)
    protected List<Message> messages;
    protected String ort;
    protected String plantal;
    protected String slutv;
    protected String startter;
    protected String startv;
    protected String undform;
    protected boolean valid;
    protected String valuta;

    /**
     * Gets the value of the antalord property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAntalord() {
        return antalord;
    }

    /**
     * Sets the value of the antalord property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAntalord(String value) {
        this.antalord = value;
    }

    /**
     * Gets the value of the antalres property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAntalres() {
        return antalres;
    }

    /**
     * Sets the value of the antalres property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAntalres(String value) {
        this.antalres = value;
    }

    /**
     * Gets the value of the dep1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDep1() {
        return dep1;
    }

    /**
     * Sets the value of the dep1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDep1(String value) {
        this.dep1 = value;
    }

    /**
     * Gets the value of the dep2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDep2() {
        return dep2;
    }

    /**
     * Sets the value of the dep2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDep2(String value) {
        this.dep2 = value;
    }

    /**
     * Gets the value of the ffgpoang property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFfgpoang() {
        return ffgpoang;
    }

    /**
     * Sets the value of the ffgpoang property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFfgpoang(BigDecimal value) {
        this.ffgpoang = value;
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
     * Gets the value of the kurskod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKurskod() {
        return kurskod;
    }

    /**
     * Sets the value of the kurskod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKurskod(String value) {
        this.kurskod = value;
    }

    /**
     * Gets the value of the kursomg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKursomg() {
        return kursomg;
    }

    /**
     * Sets the value of the kursomg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKursomg(String value) {
        this.kursomg = value;
    }

    /**
     * Gets the value of the kurstakt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKurstakt() {
        return kurstakt;
    }

    /**
     * Sets the value of the kurstakt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKurstakt(String value) {
        this.kurstakt = value;
    }

    /**
     * Gets the value of the kurstid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKurstid() {
        return kurstid;
    }

    /**
     * Sets the value of the kurstid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKurstid(String value) {
        this.kurstid = value;
    }

    /**
     * Gets the value of the kurstyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKurstyp() {
        return kurstyp;
    }

    /**
     * Sets the value of the kurstyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKurstyp(String value) {
        this.kurstyp = value;
    }

    /**
     * Gets the value of the lok1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLok1() {
        return lok1;
    }

    /**
     * Sets the value of the lok1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLok1(String value) {
        this.lok1 = value;
    }

    /**
     * Gets the value of the lok2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLok2() {
        return lok2;
    }

    /**
     * Sets the value of the lok2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLok2(String value) {
        this.lok2 = value;
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
     * Gets the value of the ort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrt() {
        return ort;
    }

    /**
     * Sets the value of the ort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrt(String value) {
        this.ort = value;
    }

    /**
     * Gets the value of the plantal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlantal() {
        return plantal;
    }

    /**
     * Sets the value of the plantal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlantal(String value) {
        this.plantal = value;
    }

    /**
     * Gets the value of the slutv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlutv() {
        return slutv;
    }

    /**
     * Sets the value of the slutv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlutv(String value) {
        this.slutv = value;
    }

    /**
     * Gets the value of the startter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartter() {
        return startter;
    }

    /**
     * Sets the value of the startter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartter(String value) {
        this.startter = value;
    }

    /**
     * Gets the value of the startv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartv() {
        return startv;
    }

    /**
     * Sets the value of the startv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartv(String value) {
        this.startv = value;
    }

    /**
     * Gets the value of the undform property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUndform() {
        return undform;
    }

    /**
     * Sets the value of the undform property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUndform(String value) {
        this.undform = value;
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
