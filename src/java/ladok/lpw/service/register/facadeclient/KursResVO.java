
package ladok.lpw.service.register.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for kursResVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="kursResVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="benamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="betyg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bskalaKod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="converted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ectsbet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ectsp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="godkProv" type="{http://facadeclient.register.service.lpw.ladok/}provResVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="kursTyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kurskod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="larare" type="{http://facadeclient.register.service.lpw.ladok/}larareVO" minOccurs="0"/>
 *         &lt;element name="nedlagd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="not" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="poang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proginr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proginrnamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proginrnamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progrnamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progrnamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="undkProv" type="{http://facadeclient.register.service.lpw.ladok/}provResVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="utbniva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="utbnivaBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="utbnivaBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "kursResVO", propOrder = {
    "benamne",
    "benamns",
    "betyg",
    "bskalaKod",
    "converted",
    "datum",
    "ectsbet",
    "ectsp",
    "godkProv",
    "kursTyp",
    "kurskod",
    "larare",
    "nedlagd",
    "not",
    "poang",
    "proginr",
    "proginrnamn",
    "proginrnamne",
    "progr",
    "progrnamn",
    "progrnamne",
    "undkProv",
    "utbniva",
    "utbnivaBenamne",
    "utbnivaBenamns"
})
public class KursResVO {

    protected String benamne;
    protected String benamns;
    protected String betyg;
    protected String bskalaKod;
    protected boolean converted;
    protected String datum;
    protected String ectsbet;
    protected String ectsp;
    @XmlElement(nillable = true)
    protected List<ProvResVO> godkProv;
    protected String kursTyp;
    protected String kurskod;
    protected LarareVO larare;
    protected String nedlagd;
    protected int not;
    protected String poang;
    protected String proginr;
    protected String proginrnamn;
    protected String proginrnamne;
    protected String progr;
    protected String progrnamn;
    protected String progrnamne;
    @XmlElement(nillable = true)
    protected List<ProvResVO> undkProv;
    protected String utbniva;
    protected String utbnivaBenamne;
    protected String utbnivaBenamns;

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
     * Gets the value of the betyg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBetyg() {
        return betyg;
    }

    /**
     * Sets the value of the betyg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBetyg(String value) {
        this.betyg = value;
    }

    /**
     * Gets the value of the bskalaKod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBskalaKod() {
        return bskalaKod;
    }

    /**
     * Sets the value of the bskalaKod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBskalaKod(String value) {
        this.bskalaKod = value;
    }

    /**
     * Gets the value of the converted property.
     * 
     */
    public boolean isConverted() {
        return converted;
    }

    /**
     * Sets the value of the converted property.
     * 
     */
    public void setConverted(boolean value) {
        this.converted = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatum(String value) {
        this.datum = value;
    }

    /**
     * Gets the value of the ectsbet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEctsbet() {
        return ectsbet;
    }

    /**
     * Sets the value of the ectsbet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEctsbet(String value) {
        this.ectsbet = value;
    }

    /**
     * Gets the value of the ectsp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEctsp() {
        return ectsp;
    }

    /**
     * Sets the value of the ectsp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEctsp(String value) {
        this.ectsp = value;
    }

    /**
     * Gets the value of the godkProv property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the godkProv property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGodkProv().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProvResVO }
     * 
     * 
     */
    public List<ProvResVO> getGodkProv() {
        if (godkProv == null) {
            godkProv = new ArrayList<ProvResVO>();
        }
        return this.godkProv;
    }

    /**
     * Gets the value of the kursTyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKursTyp() {
        return kursTyp;
    }

    /**
     * Sets the value of the kursTyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKursTyp(String value) {
        this.kursTyp = value;
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
     * Gets the value of the larare property.
     * 
     * @return
     *     possible object is
     *     {@link LarareVO }
     *     
     */
    public LarareVO getLarare() {
        return larare;
    }

    /**
     * Sets the value of the larare property.
     * 
     * @param value
     *     allowed object is
     *     {@link LarareVO }
     *     
     */
    public void setLarare(LarareVO value) {
        this.larare = value;
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
     * Gets the value of the not property.
     * 
     */
    public int getNot() {
        return not;
    }

    /**
     * Sets the value of the not property.
     * 
     */
    public void setNot(int value) {
        this.not = value;
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
     * Gets the value of the proginrnamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProginrnamn() {
        return proginrnamn;
    }

    /**
     * Sets the value of the proginrnamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProginrnamn(String value) {
        this.proginrnamn = value;
    }

    /**
     * Gets the value of the proginrnamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProginrnamne() {
        return proginrnamne;
    }

    /**
     * Sets the value of the proginrnamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProginrnamne(String value) {
        this.proginrnamne = value;
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
     * Gets the value of the progrnamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgrnamn() {
        return progrnamn;
    }

    /**
     * Sets the value of the progrnamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgrnamn(String value) {
        this.progrnamn = value;
    }

    /**
     * Gets the value of the progrnamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgrnamne() {
        return progrnamne;
    }

    /**
     * Sets the value of the progrnamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgrnamne(String value) {
        this.progrnamne = value;
    }

    /**
     * Gets the value of the undkProv property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the undkProv property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUndkProv().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProvResVO }
     * 
     * 
     */
    public List<ProvResVO> getUndkProv() {
        if (undkProv == null) {
            undkProv = new ArrayList<ProvResVO>();
        }
        return this.undkProv;
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
     * Gets the value of the utbnivaBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtbnivaBenamne() {
        return utbnivaBenamne;
    }

    /**
     * Sets the value of the utbnivaBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtbnivaBenamne(String value) {
        this.utbnivaBenamne = value;
    }

    /**
     * Gets the value of the utbnivaBenamns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtbnivaBenamns() {
        return utbnivaBenamns;
    }

    /**
     * Sets the value of the utbnivaBenamns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtbnivaBenamns(String value) {
        this.utbnivaBenamns = value;
    }

}
