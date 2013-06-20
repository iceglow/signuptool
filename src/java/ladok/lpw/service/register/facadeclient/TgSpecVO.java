
package ladok.lpw.service.register.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tgSpecVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tgSpecVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allahskBenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="allahskBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="anteckn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="landBenamn1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="landBenamn2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specHsk" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specLand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specUtbnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specUtlhsk" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spece" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tgtyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="utlhskBenamn1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="utlhskBenamn2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="utlhskNedlagd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tgSpecVO", propOrder = {
    "allahskBenamn",
    "allahskBenamne",
    "anteckn",
    "landBenamn1",
    "landBenamn2",
    "spec",
    "specHsk",
    "specLand",
    "specUtbnr",
    "specUtlhsk",
    "spece",
    "tgtyp",
    "utlhskBenamn1",
    "utlhskBenamn2",
    "utlhskNedlagd"
})
public class TgSpecVO {

    protected String allahskBenamn;
    protected String allahskBenamne;
    protected String anteckn;
    protected String landBenamn1;
    protected String landBenamn2;
    protected String spec;
    protected String specHsk;
    protected String specLand;
    protected String specUtbnr;
    protected String specUtlhsk;
    protected String spece;
    protected String tgtyp;
    protected String utlhskBenamn1;
    protected String utlhskBenamn2;
    protected String utlhskNedlagd;

    /**
     * Gets the value of the allahskBenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllahskBenamn() {
        return allahskBenamn;
    }

    /**
     * Sets the value of the allahskBenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllahskBenamn(String value) {
        this.allahskBenamn = value;
    }

    /**
     * Gets the value of the allahskBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllahskBenamne() {
        return allahskBenamne;
    }

    /**
     * Sets the value of the allahskBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllahskBenamne(String value) {
        this.allahskBenamne = value;
    }

    /**
     * Gets the value of the anteckn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnteckn() {
        return anteckn;
    }

    /**
     * Sets the value of the anteckn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnteckn(String value) {
        this.anteckn = value;
    }

    /**
     * Gets the value of the landBenamn1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandBenamn1() {
        return landBenamn1;
    }

    /**
     * Sets the value of the landBenamn1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandBenamn1(String value) {
        this.landBenamn1 = value;
    }

    /**
     * Gets the value of the landBenamn2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandBenamn2() {
        return landBenamn2;
    }

    /**
     * Sets the value of the landBenamn2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandBenamn2(String value) {
        this.landBenamn2 = value;
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
     * Gets the value of the specHsk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecHsk() {
        return specHsk;
    }

    /**
     * Sets the value of the specHsk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecHsk(String value) {
        this.specHsk = value;
    }

    /**
     * Gets the value of the specLand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecLand() {
        return specLand;
    }

    /**
     * Sets the value of the specLand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecLand(String value) {
        this.specLand = value;
    }

    /**
     * Gets the value of the specUtbnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecUtbnr() {
        return specUtbnr;
    }

    /**
     * Sets the value of the specUtbnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecUtbnr(String value) {
        this.specUtbnr = value;
    }

    /**
     * Gets the value of the specUtlhsk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecUtlhsk() {
        return specUtlhsk;
    }

    /**
     * Sets the value of the specUtlhsk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecUtlhsk(String value) {
        this.specUtlhsk = value;
    }

    /**
     * Gets the value of the spece property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpece() {
        return spece;
    }

    /**
     * Sets the value of the spece property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpece(String value) {
        this.spece = value;
    }

    /**
     * Gets the value of the tgtyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTgtyp() {
        return tgtyp;
    }

    /**
     * Sets the value of the tgtyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTgtyp(String value) {
        this.tgtyp = value;
    }

    /**
     * Gets the value of the utlhskBenamn1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtlhskBenamn1() {
        return utlhskBenamn1;
    }

    /**
     * Sets the value of the utlhskBenamn1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtlhskBenamn1(String value) {
        this.utlhskBenamn1 = value;
    }

    /**
     * Gets the value of the utlhskBenamn2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtlhskBenamn2() {
        return utlhskBenamn2;
    }

    /**
     * Sets the value of the utlhskBenamn2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtlhskBenamn2(String value) {
        this.utlhskBenamn2 = value;
    }

    /**
     * Gets the value of the utlhskNedlagd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtlhskNedlagd() {
        return utlhskNedlagd;
    }

    /**
     * Sets the value of the utlhskNedlagd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtlhskNedlagd(String value) {
        this.utlhskNedlagd = value;
    }

}
