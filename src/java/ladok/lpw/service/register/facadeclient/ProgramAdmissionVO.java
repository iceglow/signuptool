
package ladok.lpw.service.register.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for programAdmissionVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="programAdmissionVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="converted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="inrConverted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="inrPoang" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kull" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="linjeBenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="linjeBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="linjeinrBenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="linjeinrBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poang" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="proginr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="termin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="termordn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urtabell" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "programAdmissionVO", propOrder = {
    "converted",
    "inrConverted",
    "inrPoang",
    "kull",
    "linjeBenamn",
    "linjeBenamne",
    "linjeinrBenamn",
    "linjeinrBenamne",
    "poang",
    "proginr",
    "progr",
    "reg",
    "termin",
    "termordn",
    "urtabell"
})
public class ProgramAdmissionVO {

    protected boolean converted;
    protected boolean inrConverted;
    protected int inrPoang;
    protected String kull;
    protected String linjeBenamn;
    protected String linjeBenamne;
    protected String linjeinrBenamn;
    protected String linjeinrBenamne;
    protected int poang;
    protected String proginr;
    protected String progr;
    protected String reg;
    protected String termin;
    protected String termordn;
    protected String urtabell;

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
     * Gets the value of the inrConverted property.
     * 
     */
    public boolean isInrConverted() {
        return inrConverted;
    }

    /**
     * Sets the value of the inrConverted property.
     * 
     */
    public void setInrConverted(boolean value) {
        this.inrConverted = value;
    }

    /**
     * Gets the value of the inrPoang property.
     * 
     */
    public int getInrPoang() {
        return inrPoang;
    }

    /**
     * Sets the value of the inrPoang property.
     * 
     */
    public void setInrPoang(int value) {
        this.inrPoang = value;
    }

    /**
     * Gets the value of the kull property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKull() {
        return kull;
    }

    /**
     * Sets the value of the kull property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKull(String value) {
        this.kull = value;
    }

    /**
     * Gets the value of the linjeBenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinjeBenamn() {
        return linjeBenamn;
    }

    /**
     * Sets the value of the linjeBenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinjeBenamn(String value) {
        this.linjeBenamn = value;
    }

    /**
     * Gets the value of the linjeBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinjeBenamne() {
        return linjeBenamne;
    }

    /**
     * Sets the value of the linjeBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinjeBenamne(String value) {
        this.linjeBenamne = value;
    }

    /**
     * Gets the value of the linjeinrBenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinjeinrBenamn() {
        return linjeinrBenamn;
    }

    /**
     * Sets the value of the linjeinrBenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinjeinrBenamn(String value) {
        this.linjeinrBenamn = value;
    }

    /**
     * Gets the value of the linjeinrBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinjeinrBenamne() {
        return linjeinrBenamne;
    }

    /**
     * Sets the value of the linjeinrBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinjeinrBenamne(String value) {
        this.linjeinrBenamne = value;
    }

    /**
     * Gets the value of the poang property.
     * 
     */
    public int getPoang() {
        return poang;
    }

    /**
     * Sets the value of the poang property.
     * 
     */
    public void setPoang(int value) {
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
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReg() {
        return reg;
    }

    /**
     * Sets the value of the reg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReg(String value) {
        this.reg = value;
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

}
