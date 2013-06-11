
package ladok.lpw.service.registrate.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for courseRegistrationVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="courseRegistrationVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anmkodKtill" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="anmkodPtill" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="avbrottsdatum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="finform" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="genreg" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="inlkoppl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kursbenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kursbenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kurskod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kurstakt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kurstid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messages" type="{http://facadeclient.registrate.service.lpw.ladok/}message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="omgang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ortsbenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poangTermin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progbenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progbenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proginr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proginrbenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proginrbenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reg" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="regTill" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="regTyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="slutv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="termordn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="termordnKurs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="termreg" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="undform" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urtabell" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urtabell2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="villkor" type="{http://facadeclient.registrate.service.lpw.ladok/}villkorVO" minOccurs="0"/>
 *         &lt;element name="villkor2" type="{http://facadeclient.registrate.service.lpw.ladok/}villkorVO" minOccurs="0"/>
 *         &lt;element name="villkor3" type="{http://facadeclient.registrate.service.lpw.ladok/}villkorVO" minOccurs="0"/>
 *         &lt;element name="webRegFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="webRegTill" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="webRegTom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "courseRegistrationVO", propOrder = {
    "anmkodKtill",
    "anmkodPtill",
    "avbrottsdatum",
    "finform",
    "genreg",
    "inlkoppl",
    "kursbenamn",
    "kursbenamne",
    "kurskod",
    "kurstakt",
    "kurstid",
    "messages",
    "omgang",
    "ort",
    "ortsbenamn",
    "poang",
    "poangTermin",
    "progbenamn",
    "progbenamne",
    "proginr",
    "proginrbenamn",
    "proginrbenamne",
    "progr",
    "reg",
    "regTill",
    "regTyp",
    "slutv",
    "startter",
    "startv",
    "termordn",
    "termordnKurs",
    "termreg",
    "undform",
    "urtabell",
    "urtabell2",
    "valid",
    "villkor",
    "villkor2",
    "villkor3",
    "webRegFrom",
    "webRegTill",
    "webRegTom"
})
public class CourseRegistrationVO {

    protected String anmkodKtill;
    protected String anmkodPtill;
    protected String avbrottsdatum;
    protected String finform;
    protected boolean genreg;
    protected String inlkoppl;
    protected String kursbenamn;
    protected String kursbenamne;
    protected String kurskod;
    protected String kurstakt;
    protected String kurstid;
    @XmlElement(nillable = true)
    protected List<Message> messages;
    protected String omgang;
    protected String ort;
    protected String ortsbenamn;
    protected String poang;
    protected String poangTermin;
    protected String progbenamn;
    protected String progbenamne;
    protected String proginr;
    protected String proginrbenamn;
    protected String proginrbenamne;
    protected String progr;
    protected boolean reg;
    protected boolean regTill;
    protected String regTyp;
    protected String slutv;
    protected String startter;
    protected String startv;
    protected String termordn;
    protected String termordnKurs;
    protected boolean termreg;
    protected String undform;
    protected String urtabell;
    protected String urtabell2;
    protected boolean valid;
    protected VillkorVO villkor;
    protected VillkorVO villkor2;
    protected VillkorVO villkor3;
    protected String webRegFrom;
    protected boolean webRegTill;
    protected String webRegTom;

    /**
     * Gets the value of the anmkodKtill property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnmkodKtill() {
        return anmkodKtill;
    }

    /**
     * Sets the value of the anmkodKtill property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnmkodKtill(String value) {
        this.anmkodKtill = value;
    }

    /**
     * Gets the value of the anmkodPtill property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnmkodPtill() {
        return anmkodPtill;
    }

    /**
     * Sets the value of the anmkodPtill property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnmkodPtill(String value) {
        this.anmkodPtill = value;
    }

    /**
     * Gets the value of the avbrottsdatum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvbrottsdatum() {
        return avbrottsdatum;
    }

    /**
     * Sets the value of the avbrottsdatum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvbrottsdatum(String value) {
        this.avbrottsdatum = value;
    }

    /**
     * Gets the value of the finform property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinform() {
        return finform;
    }

    /**
     * Sets the value of the finform property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinform(String value) {
        this.finform = value;
    }

    /**
     * Gets the value of the genreg property.
     * 
     */
    public boolean isGenreg() {
        return genreg;
    }

    /**
     * Sets the value of the genreg property.
     * 
     */
    public void setGenreg(boolean value) {
        this.genreg = value;
    }

    /**
     * Gets the value of the inlkoppl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInlkoppl() {
        return inlkoppl;
    }

    /**
     * Sets the value of the inlkoppl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInlkoppl(String value) {
        this.inlkoppl = value;
    }

    /**
     * Gets the value of the kursbenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKursbenamn() {
        return kursbenamn;
    }

    /**
     * Sets the value of the kursbenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKursbenamn(String value) {
        this.kursbenamn = value;
    }

    /**
     * Gets the value of the kursbenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKursbenamne() {
        return kursbenamne;
    }

    /**
     * Sets the value of the kursbenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKursbenamne(String value) {
        this.kursbenamne = value;
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
     * Gets the value of the omgang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOmgang() {
        return omgang;
    }

    /**
     * Sets the value of the omgang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOmgang(String value) {
        this.omgang = value;
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
     * Gets the value of the poangTermin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoangTermin() {
        return poangTermin;
    }

    /**
     * Sets the value of the poangTermin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoangTermin(String value) {
        this.poangTermin = value;
    }

    /**
     * Gets the value of the progbenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgbenamn() {
        return progbenamn;
    }

    /**
     * Sets the value of the progbenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgbenamn(String value) {
        this.progbenamn = value;
    }

    /**
     * Gets the value of the progbenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgbenamne() {
        return progbenamne;
    }

    /**
     * Sets the value of the progbenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgbenamne(String value) {
        this.progbenamne = value;
    }

    /**
     * Gets the value of the proginr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProginr() {
        return proginr;
    }

    /**
     * Sets the value of the proginr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProginr(String value) {
        this.proginr = value;
    }

    /**
     * Gets the value of the proginrbenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProginrbenamn() {
        return proginrbenamn;
    }

    /**
     * Sets the value of the proginrbenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProginrbenamn(String value) {
        this.proginrbenamn = value;
    }

    /**
     * Gets the value of the proginrbenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProginrbenamne() {
        return proginrbenamne;
    }

    /**
     * Sets the value of the proginrbenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProginrbenamne(String value) {
        this.proginrbenamne = value;
    }

    /**
     * Gets the value of the progr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgr() {
        return progr;
    }

    /**
     * Sets the value of the progr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgr(String value) {
        this.progr = value;
    }

    /**
     * Gets the value of the reg property.
     * 
     */
    public boolean isReg() {
        return reg;
    }

    /**
     * Sets the value of the reg property.
     * 
     */
    public void setReg(boolean value) {
        this.reg = value;
    }

    /**
     * Gets the value of the regTill property.
     * 
     */
    public boolean isRegTill() {
        return regTill;
    }

    /**
     * Sets the value of the regTill property.
     * 
     */
    public void setRegTill(boolean value) {
        this.regTill = value;
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
     * Gets the value of the termordn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermordn() {
        return termordn;
    }

    /**
     * Sets the value of the termordn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermordn(String value) {
        this.termordn = value;
    }

    /**
     * Gets the value of the termordnKurs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermordnKurs() {
        return termordnKurs;
    }

    /**
     * Sets the value of the termordnKurs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermordnKurs(String value) {
        this.termordnKurs = value;
    }

    /**
     * Gets the value of the termreg property.
     * 
     */
    public boolean isTermreg() {
        return termreg;
    }

    /**
     * Sets the value of the termreg property.
     * 
     */
    public void setTermreg(boolean value) {
        this.termreg = value;
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
     * Gets the value of the urtabell property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrtabell() {
        return urtabell;
    }

    /**
     * Sets the value of the urtabell property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrtabell(String value) {
        this.urtabell = value;
    }

    /**
     * Gets the value of the urtabell2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrtabell2() {
        return urtabell2;
    }

    /**
     * Sets the value of the urtabell2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrtabell2(String value) {
        this.urtabell2 = value;
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
     * Gets the value of the villkor property.
     * 
     * @return
     *     possible object is
     *     {@link VillkorVO }
     *     
     */
    public VillkorVO getVillkor() {
        return villkor;
    }

    /**
     * Sets the value of the villkor property.
     * 
     * @param value
     *     allowed object is
     *     {@link VillkorVO }
     *     
     */
    public void setVillkor(VillkorVO value) {
        this.villkor = value;
    }

    /**
     * Gets the value of the villkor2 property.
     * 
     * @return
     *     possible object is
     *     {@link VillkorVO }
     *     
     */
    public VillkorVO getVillkor2() {
        return villkor2;
    }

    /**
     * Sets the value of the villkor2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link VillkorVO }
     *     
     */
    public void setVillkor2(VillkorVO value) {
        this.villkor2 = value;
    }

    /**
     * Gets the value of the villkor3 property.
     * 
     * @return
     *     possible object is
     *     {@link VillkorVO }
     *     
     */
    public VillkorVO getVillkor3() {
        return villkor3;
    }

    /**
     * Sets the value of the villkor3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link VillkorVO }
     *     
     */
    public void setVillkor3(VillkorVO value) {
        this.villkor3 = value;
    }

    /**
     * Gets the value of the webRegFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebRegFrom() {
        return webRegFrom;
    }

    /**
     * Sets the value of the webRegFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebRegFrom(String value) {
        this.webRegFrom = value;
    }

    /**
     * Gets the value of the webRegTill property.
     * 
     */
    public boolean isWebRegTill() {
        return webRegTill;
    }

    /**
     * Sets the value of the webRegTill property.
     * 
     */
    public void setWebRegTill(boolean value) {
        this.webRegTill = value;
    }

    /**
     * Gets the value of the webRegTom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebRegTom() {
        return webRegTom;
    }

    /**
     * Sets the value of the webRegTom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebRegTom(String value) {
        this.webRegTom = value;
    }

}
