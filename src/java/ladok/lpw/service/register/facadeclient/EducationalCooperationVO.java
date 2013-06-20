
package ladok.lpw.service.register.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for educationalCooperationVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="educationalCooperationVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cooperatingUniversities" type="{http://facadeclient.register.service.lpw.ladok/}coopUniversitiesVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="progrBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progrBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progrKod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="samutbBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="samutbBenamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="samutbKod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "educationalCooperationVO", propOrder = {
    "cooperatingUniversities",
    "progrBenamne",
    "progrBenamns",
    "progrKod",
    "samutbBenamne",
    "samutbBenamns",
    "samutbKod"
})
public class EducationalCooperationVO {

    @XmlElement(nillable = true)
    protected List<CoopUniversitiesVO> cooperatingUniversities;
    protected String progrBenamne;
    protected String progrBenamns;
    protected String progrKod;
    protected String samutbBenamne;
    protected String samutbBenamns;
    protected String samutbKod;

    /**
     * Gets the value of the cooperatingUniversities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cooperatingUniversities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCooperatingUniversities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CoopUniversitiesVO }
     * 
     * 
     */
    public List<CoopUniversitiesVO> getCooperatingUniversities() {
        if (cooperatingUniversities == null) {
            cooperatingUniversities = new ArrayList<CoopUniversitiesVO>();
        }
        return this.cooperatingUniversities;
    }

    /**
     * Gets the value of the progrBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgrBenamne() {
        return progrBenamne;
    }

    /**
     * Sets the value of the progrBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgrBenamne(String value) {
        this.progrBenamne = value;
    }

    /**
     * Gets the value of the progrBenamns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgrBenamns() {
        return progrBenamns;
    }

    /**
     * Sets the value of the progrBenamns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgrBenamns(String value) {
        this.progrBenamns = value;
    }

    /**
     * Gets the value of the progrKod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgrKod() {
        return progrKod;
    }

    /**
     * Sets the value of the progrKod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgrKod(String value) {
        this.progrKod = value;
    }

    /**
     * Gets the value of the samutbBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSamutbBenamne() {
        return samutbBenamne;
    }

    /**
     * Sets the value of the samutbBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSamutbBenamne(String value) {
        this.samutbBenamne = value;
    }

    /**
     * Gets the value of the samutbBenamns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSamutbBenamns() {
        return samutbBenamns;
    }

    /**
     * Sets the value of the samutbBenamns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSamutbBenamns(String value) {
        this.samutbBenamns = value;
    }

    /**
     * Gets the value of the samutbKod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSamutbKod() {
        return samutbKod;
    }

    /**
     * Sets the value of the samutbKod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSamutbKod(String value) {
        this.samutbKod = value;
    }

}
