
package ladok.lpw.service.register.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tillgodoKursVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tillgodoKursVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="betyg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="converted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ectsbet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ectsp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hskBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hskBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hskKod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kursBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kursBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kursKod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kursPoang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="land" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="landBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="landBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specBetskala" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "tillgodoKursVO", propOrder = {
    "betyg",
    "converted",
    "datum",
    "ectsbet",
    "ectsp",
    "hskBenamne",
    "hskBenamns",
    "hskKod",
    "kursBenamne",
    "kursBenamns",
    "kursKod",
    "kursPoang",
    "land",
    "landBenamne",
    "landBenamns",
    "specBetskala",
    "utbniva",
    "utbnivaBenamne",
    "utbnivaBenamns"
})
public class TillgodoKursVO {

    protected String betyg;
    protected boolean converted;
    protected String datum;
    protected String ectsbet;
    protected String ectsp;
    protected String hskBenamne;
    protected String hskBenamns;
    protected String hskKod;
    protected String kursBenamne;
    protected String kursBenamns;
    protected String kursKod;
    protected String kursPoang;
    protected String land;
    protected String landBenamne;
    protected String landBenamns;
    protected String specBetskala;
    protected String utbniva;
    protected String utbnivaBenamne;
    protected String utbnivaBenamns;

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
     * Gets the value of the hskKod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHskKod() {
        return hskKod;
    }

    /**
     * Sets the value of the hskKod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHskKod(String value) {
        this.hskKod = value;
    }

    /**
     * Gets the value of the kursBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKursBenamne() {
        return kursBenamne;
    }

    /**
     * Sets the value of the kursBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKursBenamne(String value) {
        this.kursBenamne = value;
    }

    /**
     * Gets the value of the kursBenamns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKursBenamns() {
        return kursBenamns;
    }

    /**
     * Sets the value of the kursBenamns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKursBenamns(String value) {
        this.kursBenamns = value;
    }

    /**
     * Gets the value of the kursKod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKursKod() {
        return kursKod;
    }

    /**
     * Sets the value of the kursKod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKursKod(String value) {
        this.kursKod = value;
    }

    /**
     * Gets the value of the kursPoang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKursPoang() {
        return kursPoang;
    }

    /**
     * Sets the value of the kursPoang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKursPoang(String value) {
        this.kursPoang = value;
    }

    /**
     * Gets the value of the land property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLand() {
        return land;
    }

    /**
     * Sets the value of the land property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLand(String value) {
        this.land = value;
    }

    /**
     * Gets the value of the landBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandBenamne() {
        return landBenamne;
    }

    /**
     * Sets the value of the landBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandBenamne(String value) {
        this.landBenamne = value;
    }

    /**
     * Gets the value of the landBenamns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandBenamns() {
        return landBenamns;
    }

    /**
     * Sets the value of the landBenamns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandBenamns(String value) {
        this.landBenamns = value;
    }

    /**
     * Gets the value of the specBetskala property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecBetskala() {
        return specBetskala;
    }

    /**
     * Sets the value of the specBetskala property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecBetskala(String value) {
        this.specBetskala = value;
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
