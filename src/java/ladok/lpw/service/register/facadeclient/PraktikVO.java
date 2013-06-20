
package ladok.lpw.service.register.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for praktikVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="praktikVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="antal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="benamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="diarieNr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prog" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progInr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "praktikVO", propOrder = {
    "antal",
    "benamne",
    "benamns",
    "datum",
    "diarieNr",
    "kod",
    "prog",
    "progBenamne",
    "progBenamns",
    "progInr",
    "spec",
    "type"
})
public class PraktikVO {

    protected int antal;
    protected String benamne;
    protected String benamns;
    protected String datum;
    protected String diarieNr;
    protected String kod;
    protected String prog;
    protected String progBenamne;
    protected String progBenamns;
    protected String progInr;
    protected String spec;
    protected int type;

    /**
     * Gets the value of the antal property.
     * 
     */
    public int getAntal() {
        return antal;
    }

    /**
     * Sets the value of the antal property.
     * 
     */
    public void setAntal(int value) {
        this.antal = value;
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
     * Gets the value of the diarieNr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiarieNr() {
        return diarieNr;
    }

    /**
     * Sets the value of the diarieNr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiarieNr(String value) {
        this.diarieNr = value;
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
     * Gets the value of the prog property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProg() {
        return prog;
    }

    /**
     * Sets the value of the prog property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProg(String value) {
        this.prog = value;
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
     * Gets the value of the progInr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgInr() {
        return progInr;
    }

    /**
     * Sets the value of the progInr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgInr(String value) {
        this.progInr = value;
    }

    /**
     * Gets the value of the spec property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpec() {
        return spec;
    }

    /**
     * Sets the value of the spec property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpec(String value) {
        this.spec = value;
    }

    /**
     * Gets the value of the type property.
     * 
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     */
    public void setType(int value) {
        this.type = value;
    }

}
