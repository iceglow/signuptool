
package ladok.lpw.service.utility.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findHsk complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findHsk">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://facadeclient.utility.service.lpw.ladok/}userVO" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://facadeclient.utility.service.lpw.ladok/}utilityHskVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findHsk", propOrder = {
    "arg0",
    "arg1"
})
public class FindHsk {

    protected UserVO arg0;
    protected UtilityHskVO arg1;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link UserVO }
     *     
     */
    public UserVO getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserVO }
     *     
     */
    public void setArg0(UserVO value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     * @return
     *     possible object is
     *     {@link UtilityHskVO }
     *     
     */
    public UtilityHskVO getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link UtilityHskVO }
     *     
     */
    public void setArg1(UtilityHskVO value) {
        this.arg1 = value;
    }

}
