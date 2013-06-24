
package ladok.lpw.service.register.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for termRegVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="termRegVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="benamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inrBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inrBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inrPoang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="konvert" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="regTyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="termOrdn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="termin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "termRegVO", propOrder = {
    "benamne",
    "benamns",
    "inr",
    "inrBenamne",
    "inrBenamns",
    "inrPoang",
    "konvert",
    "poang",
    "progr",
    "regTyp",
    "termOrdn",
    "termin"
})
public class TermRegVO {

    protected String benamne;
    protected String benamns;
    protected String inr;
    protected String inrBenamne;
    protected String inrBenamns;
    protected String inrPoang;
    protected String konvert;
    protected String poang;
    protected String progr;
    protected String regTyp;
    protected String termOrdn;
    protected String termin;

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
     * Gets the value of the inrPoang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInrPoang() {
        return inrPoang;
    }

    /**
     * Sets the value of the inrPoang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInrPoang(String value) {
        this.inrPoang = value;
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

}
