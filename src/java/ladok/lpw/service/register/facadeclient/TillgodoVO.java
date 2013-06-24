
package ladok.lpw.service.register.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tillgodoVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tillgodoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="benamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="besDatum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="beslutsfattare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="converted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ectsbet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ectsp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kursKod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kurser" type="{http://facadeclient.register.service.lpw.ladok/}tillgodoKursVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lopNr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "tillgodoVO", propOrder = {
    "benamne",
    "benamns",
    "besDatum",
    "beslutsfattare",
    "converted",
    "ectsbet",
    "ectsp",
    "kursKod",
    "kurser",
    "lopNr",
    "poang",
    "utbniva",
    "utbnivaBenamne",
    "utbnivaBenamns"
})
public class TillgodoVO {

    protected String benamne;
    protected String benamns;
    protected String besDatum;
    protected String beslutsfattare;
    protected boolean converted;
    protected String ectsbet;
    protected String ectsp;
    protected String kursKod;
    @XmlElement(nillable = true)
    protected List<TillgodoKursVO> kurser;
    protected String lopNr;
    protected String poang;
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
     * Gets the value of the besDatum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBesDatum() {
        return besDatum;
    }

    /**
     * Sets the value of the besDatum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBesDatum(String value) {
        this.besDatum = value;
    }

    /**
     * Gets the value of the beslutsfattare property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeslutsfattare() {
        return beslutsfattare;
    }

    /**
     * Sets the value of the beslutsfattare property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeslutsfattare(String value) {
        this.beslutsfattare = value;
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
     * Gets the value of the kurser property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kurser property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKurser().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TillgodoKursVO }
     * 
     * 
     */
    public List<TillgodoKursVO> getKurser() {
        if (kurser == null) {
            kurser = new ArrayList<TillgodoKursVO>();
        }
        return this.kurser;
    }

    /**
     * Gets the value of the lopNr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLopNr() {
        return lopNr;
    }

    /**
     * Sets the value of the lopNr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLopNr(String value) {
        this.lopNr = value;
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
