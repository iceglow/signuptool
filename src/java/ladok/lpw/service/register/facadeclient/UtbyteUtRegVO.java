
package ladok.lpw.service.register.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for utbyteUtRegVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="utbyteUtRegVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ansvInst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="konvert" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="koord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="koordNamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="landskod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="slutvecka" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startvecka" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="termin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UProgBenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UProgr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UUniv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UUnivBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UUnivBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "utbyteUtRegVO", propOrder = {
    "ansvInst",
    "iBenamne",
    "iBenamns",
    "inr",
    "konvert",
    "koord",
    "koordNamn",
    "lBenamne",
    "lBenamns",
    "landskod",
    "poang",
    "progr",
    "slutvecka",
    "startvecka",
    "termin",
    "uProgBenamn",
    "uProgr",
    "uUniv",
    "uUnivBenamne",
    "uUnivBenamns"
})
public class UtbyteUtRegVO {

    protected String ansvInst;
    @XmlElement(name = "IBenamne")
    protected String iBenamne;
    @XmlElement(name = "IBenamns")
    protected String iBenamns;
    protected String inr;
    protected String konvert;
    protected String koord;
    protected String koordNamn;
    @XmlElement(name = "LBenamne")
    protected String lBenamne;
    @XmlElement(name = "LBenamns")
    protected String lBenamns;
    protected String landskod;
    protected String poang;
    protected String progr;
    protected String slutvecka;
    protected String startvecka;
    protected String termin;
    @XmlElement(name = "UProgBenamn")
    protected String uProgBenamn;
    @XmlElement(name = "UProgr")
    protected String uProgr;
    @XmlElement(name = "UUniv")
    protected String uUniv;
    @XmlElement(name = "UUnivBenamne")
    protected String uUnivBenamne;
    @XmlElement(name = "UUnivBenamns")
    protected String uUnivBenamns;

    /**
     * Gets the value of the ansvInst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnsvInst() {
        return ansvInst;
    }

    /**
     * Sets the value of the ansvInst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnsvInst(String value) {
        this.ansvInst = value;
    }

    /**
     * Gets the value of the iBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBenamne() {
        return iBenamne;
    }

    /**
     * Sets the value of the iBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBenamne(String value) {
        this.iBenamne = value;
    }

    /**
     * Gets the value of the iBenamns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBenamns() {
        return iBenamns;
    }

    /**
     * Sets the value of the iBenamns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBenamns(String value) {
        this.iBenamns = value;
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
     * Gets the value of the koord property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKoord() {
        return koord;
    }

    /**
     * Sets the value of the koord property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKoord(String value) {
        this.koord = value;
    }

    /**
     * Gets the value of the koordNamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKoordNamn() {
        return koordNamn;
    }

    /**
     * Sets the value of the koordNamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKoordNamn(String value) {
        this.koordNamn = value;
    }

    /**
     * Gets the value of the lBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLBenamne() {
        return lBenamne;
    }

    /**
     * Sets the value of the lBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLBenamne(String value) {
        this.lBenamne = value;
    }

    /**
     * Gets the value of the lBenamns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLBenamns() {
        return lBenamns;
    }

    /**
     * Sets the value of the lBenamns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLBenamns(String value) {
        this.lBenamns = value;
    }

    /**
     * Gets the value of the landskod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandskod() {
        return landskod;
    }

    /**
     * Sets the value of the landskod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandskod(String value) {
        this.landskod = value;
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
     * Gets the value of the slutvecka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlutvecka() {
        return slutvecka;
    }

    /**
     * Sets the value of the slutvecka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlutvecka(String value) {
        this.slutvecka = value;
    }

    /**
     * Gets the value of the startvecka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartvecka() {
        return startvecka;
    }

    /**
     * Sets the value of the startvecka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartvecka(String value) {
        this.startvecka = value;
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
     * Gets the value of the uProgBenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUProgBenamn() {
        return uProgBenamn;
    }

    /**
     * Sets the value of the uProgBenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUProgBenamn(String value) {
        this.uProgBenamn = value;
    }

    /**
     * Gets the value of the uProgr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUProgr() {
        return uProgr;
    }

    /**
     * Sets the value of the uProgr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUProgr(String value) {
        this.uProgr = value;
    }

    /**
     * Gets the value of the uUniv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUUniv() {
        return uUniv;
    }

    /**
     * Sets the value of the uUniv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUUniv(String value) {
        this.uUniv = value;
    }

    /**
     * Gets the value of the uUnivBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUUnivBenamne() {
        return uUnivBenamne;
    }

    /**
     * Sets the value of the uUnivBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUUnivBenamne(String value) {
        this.uUnivBenamne = value;
    }

    /**
     * Gets the value of the uUnivBenamns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUUnivBenamns() {
        return uUnivBenamns;
    }

    /**
     * Sets the value of the uUnivBenamns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUUnivBenamns(String value) {
        this.uUnivBenamns = value;
    }

}
