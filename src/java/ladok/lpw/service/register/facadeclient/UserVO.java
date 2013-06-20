
package ladok.lpw.service.register.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for userVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authinfovo" type="{http://facadeclient.register.service.lpw.ladok/}authInfoVO" minOccurs="0"/>
 *         &lt;element name="bksinfovo" type="{http://facadeclient.register.service.lpw.ladok/}bksInfoVO" minOccurs="0"/>
 *         &lt;element name="errorObject" type="{http://facadeclient.register.service.lpw.ladok/}errorObject" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="numberOfErrors" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="personvo" type="{http://facadeclient.register.service.lpw.ladok/}personVO" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userVO", propOrder = {
    "authinfovo",
    "bksinfovo",
    "errorObject",
    "numberOfErrors",
    "personvo",
    "type",
    "uid",
    "valid"
})
public class UserVO {

    protected AuthInfoVO authinfovo;
    protected BksInfoVO bksinfovo;
    @XmlElement(nillable = true)
    protected List<ErrorObject> errorObject;
    protected int numberOfErrors;
    protected PersonVO personvo;
    protected String type;
    protected String uid;
    protected boolean valid;

    /**
     * Gets the value of the authinfovo property.
     * 
     * @return
     *     possible object is
     *     {@link AuthInfoVO }
     *     
     */
    public AuthInfoVO getAuthinfovo() {
        return authinfovo;
    }

    /**
     * Sets the value of the authinfovo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthInfoVO }
     *     
     */
    public void setAuthinfovo(AuthInfoVO value) {
        this.authinfovo = value;
    }

    /**
     * Gets the value of the bksinfovo property.
     * 
     * @return
     *     possible object is
     *     {@link BksInfoVO }
     *     
     */
    public BksInfoVO getBksinfovo() {
        return bksinfovo;
    }

    /**
     * Sets the value of the bksinfovo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BksInfoVO }
     *     
     */
    public void setBksinfovo(BksInfoVO value) {
        this.bksinfovo = value;
    }

    /**
     * Gets the value of the errorObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errorObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrorObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErrorObject }
     * 
     * 
     */
    public List<ErrorObject> getErrorObject() {
        if (errorObject == null) {
            errorObject = new ArrayList<ErrorObject>();
        }
        return this.errorObject;
    }

    /**
     * Gets the value of the numberOfErrors property.
     * 
     */
    public int getNumberOfErrors() {
        return numberOfErrors;
    }

    /**
     * Sets the value of the numberOfErrors property.
     * 
     */
    public void setNumberOfErrors(int value) {
        this.numberOfErrors = value;
    }

    /**
     * Gets the value of the personvo property.
     * 
     * @return
     *     possible object is
     *     {@link PersonVO }
     *     
     */
    public PersonVO getPersonvo() {
        return personvo;
    }

    /**
     * Sets the value of the personvo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonVO }
     *     
     */
    public void setPersonvo(PersonVO value) {
        this.personvo = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the uid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the value of the uid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUid(String value) {
        this.uid = value;
    }

    /**
     * Gets the value of the valid property.
     * 
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * Sets the value of the valid property.
     * 
     */
    public void setValid(boolean value) {
        this.valid = value;
    }

}
