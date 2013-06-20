
package ladok.lpw.service.register.facadeclient;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for courseAdmissionVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="courseAdmissionVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anmalt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="converted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="kursBenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kursBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kursKod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poang" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="proginr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="termin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "courseAdmissionVO", propOrder = {
    "anmalt",
    "converted",
    "kursBenamn",
    "kursBenamne",
    "kursKod",
    "poang",
    "proginr",
    "progr",
    "reg",
    "termin",
    "urtabell"
})
public class CourseAdmissionVO {

    protected String anmalt;
    protected boolean converted;
    protected String kursBenamn;
    protected String kursBenamne;
    protected String kursKod;
    protected BigDecimal poang;
    protected String proginr;
    protected String progr;
    protected String reg;
    protected String termin;
    protected String urtabell;

    /**
     * Gets the value of the anmalt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnmalt() {
        return anmalt;
    }

    /**
     * Sets the value of the anmalt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnmalt(String value) {
        this.anmalt = value;
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
     * Gets the value of the kursBenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKursBenamn() {
        return kursBenamn;
    }

    /**
     * Sets the value of the kursBenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKursBenamn(String value) {
        this.kursBenamn = value;
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
