
package ladok.lpw.service.register.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for coopUniversitiesVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="coopUniversitiesVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hskBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hskBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hskKod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="landBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="landBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="utlhskBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="utlhskBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="utlhskKod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "coopUniversitiesVO", propOrder = {
    "hskBenamne",
    "hskBenamns",
    "hskKod",
    "landBenamne",
    "landBenamns",
    "utlhskBenamne",
    "utlhskBenamns",
    "utlhskKod"
})
public class CoopUniversitiesVO {

    protected String hskBenamne;
    protected String hskBenamns;
    protected String hskKod;
    protected String landBenamne;
    protected String landBenamns;
    protected String utlhskBenamne;
    protected String utlhskBenamns;
    protected String utlhskKod;

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
     * Gets the value of the utlhskBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtlhskBenamne() {
        return utlhskBenamne;
    }

    /**
     * Sets the value of the utlhskBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtlhskBenamne(String value) {
        this.utlhskBenamne = value;
    }

    /**
     * Gets the value of the utlhskBenamns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtlhskBenamns() {
        return utlhskBenamns;
    }

    /**
     * Sets the value of the utlhskBenamns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtlhskBenamns(String value) {
        this.utlhskBenamns = value;
    }

    /**
     * Gets the value of the utlhskKod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtlhskKod() {
        return utlhskKod;
    }

    /**
     * Sets the value of the utlhskKod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtlhskKod(String value) {
        this.utlhskKod = value;
    }

}
