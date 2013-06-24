
package ladok.lpw.service.register.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for kursRegVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="kursRegVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="avbrDatum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="avbruten" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="benamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="grpTillhor" type="{http://facadeclient.register.service.lpw.ladok/}grpTillhorVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="inomkort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inrBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inrBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inrKod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="konvert" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kurskod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kursomg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kurstakt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kurstid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kurstyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ortsbenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ortskod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poangPerTermin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progKod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="regTyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="slutv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="termOrdn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="termin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="undForm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "kursRegVO", propOrder = {
    "avbrDatum",
    "avbruten",
    "benamne",
    "benamns",
    "grpTillhor",
    "inomkort",
    "inrBenamne",
    "inrBenamns",
    "inrKod",
    "inst",
    "konvert",
    "kurskod",
    "kursomg",
    "kurstakt",
    "kurstid",
    "kurstyp",
    "ortsbenamn",
    "ortskod",
    "poang",
    "poangPerTermin",
    "progBenamne",
    "progBenamns",
    "progKod",
    "regTyp",
    "slutv",
    "startv",
    "termOrdn",
    "termin",
    "undForm"
})
public class KursRegVO {

    protected String avbrDatum;
    protected boolean avbruten;
    protected String benamne;
    protected String benamns;
    @XmlElement(nillable = true)
    protected List<GrpTillhorVO> grpTillhor;
    protected String inomkort;
    protected String inrBenamne;
    protected String inrBenamns;
    protected String inrKod;
    protected String inst;
    protected String konvert;
    protected String kurskod;
    protected String kursomg;
    protected String kurstakt;
    protected String kurstid;
    protected String kurstyp;
    protected String ortsbenamn;
    protected String ortskod;
    protected String poang;
    protected String poangPerTermin;
    protected String progBenamne;
    protected String progBenamns;
    protected String progKod;
    protected String regTyp;
    protected String slutv;
    protected String startv;
    protected String termOrdn;
    protected String termin;
    protected String undForm;

    /**
     * Gets the value of the avbrDatum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvbrDatum() {
        return avbrDatum;
    }

    /**
     * Sets the value of the avbrDatum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvbrDatum(String value) {
        this.avbrDatum = value;
    }

    /**
     * Gets the value of the avbruten property.
     * 
     */
    public boolean isAvbruten() {
        return avbruten;
    }

    /**
     * Sets the value of the avbruten property.
     * 
     */
    public void setAvbruten(boolean value) {
        this.avbruten = value;
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
     * Gets the value of the grpTillhor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grpTillhor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrpTillhor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GrpTillhorVO }
     * 
     * 
     */
    public List<GrpTillhorVO> getGrpTillhor() {
        if (grpTillhor == null) {
            grpTillhor = new ArrayList<GrpTillhorVO>();
        }
        return this.grpTillhor;
    }

    /**
     * Gets the value of the inomkort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInomkort() {
        return inomkort;
    }

    /**
     * Sets the value of the inomkort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInomkort(String value) {
        this.inomkort = value;
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
     * Gets the value of the inrKod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInrKod() {
        return inrKod;
    }

    /**
     * Sets the value of the inrKod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInrKod(String value) {
        this.inrKod = value;
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
     * Gets the value of the ortsbenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrtsbenamn() {
        return ortsbenamn;
    }

    /**
     * Sets the value of the ortsbenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrtsbenamn(String value) {
        this.ortsbenamn = value;
    }

    /**
     * Gets the value of the ortskod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrtskod() {
        return ortskod;
    }

    /**
     * Sets the value of the ortskod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrtskod(String value) {
        this.ortskod = value;
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
     * Gets the value of the poangPerTermin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoangPerTermin() {
        return poangPerTermin;
    }

    /**
     * Sets the value of the poangPerTermin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoangPerTermin(String value) {
        this.poangPerTermin = value;
    }

    /**
     * Gets the value of the progBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgBenamne() {
        return progBenamne;
    }

    /**
     * Sets the value of the progBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgBenamne(String value) {
        this.progBenamne = value;
    }

    /**
     * Gets the value of the progBenamns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgBenamns() {
        return progBenamns;
    }

    /**
     * Sets the value of the progBenamns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgBenamns(String value) {
        this.progBenamns = value;
    }

    /**
     * Gets the value of the progKod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgKod() {
        return progKod;
    }

    /**
     * Sets the value of the progKod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgKod(String value) {
        this.progKod = value;
    }

    /**
     * Gets the value of the regTyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegTyp() {
        return regTyp;
    }

    /**
     * Sets the value of the regTyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegTyp(String value) {
        this.regTyp = value;
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
     * Gets the value of the termOrdn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermOrdn() {
        return termOrdn;
    }

    /**
     * Sets the value of the termOrdn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermOrdn(String value) {
        this.termOrdn = value;
    }

    /**
     * Gets the value of the termin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermin() {
        return termin;
    }

    /**
     * Sets the value of the termin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermin(String value) {
        this.termin = value;
    }

    /**
     * Gets the value of the undForm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUndForm() {
        return undForm;
    }

    /**
     * Sets the value of the undForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUndForm(String value) {
        this.undForm = value;
    }

}
