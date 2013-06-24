
package ladok.lpw.service.register.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for studAvgVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="studAvgVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="existingstatus" type="{http://facadeclient.register.service.lpw.ladok/}studAvgStatusVO" minOccurs="0"/>
 *         &lt;element name="futurestatus" type="{http://facadeclient.register.service.lpw.ladok/}studAvgStatusVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "studAvgVO", propOrder = {
    "existingstatus",
    "futurestatus"
})
public class StudAvgVO {

    protected StudAvgStatusVO existingstatus;
    protected StudAvgStatusVO futurestatus;

    /**
     * Gets the value of the existingstatus property.
     * 
     * @return
     *     possible object is
     *     {@link StudAvgStatusVO }
     *     
     */
    public StudAvgStatusVO getExistingstatus() {
        return existingstatus;
    }

    /**
     * Sets the value of the existingstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudAvgStatusVO }
     *     
     */
    public void setExistingstatus(StudAvgStatusVO value) {
        this.existingstatus = value;
    }

    /**
     * Gets the value of the futurestatus property.
     * 
     * @return
     *     possible object is
     *     {@link StudAvgStatusVO }
     *     
     */
    public StudAvgStatusVO getFuturestatus() {
        return futurestatus;
    }

    /**
     * Sets the value of the futurestatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudAvgStatusVO }
     *     
     */
    public void setFuturestatus(StudAvgStatusVO value) {
        this.futurestatus = value;
    }

}
