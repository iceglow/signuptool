
package ladok.lpw.service.registrate.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getFutureSemesterRegSuggestionsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getFutureSemesterRegSuggestionsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://facadeclient.registrate.service.lpw.ladok/}semesterSuggestionVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFutureSemesterRegSuggestionsResponse", propOrder = {
    "_return"
})
public class GetFutureSemesterRegSuggestionsResponse {

    @XmlElement(name = "return")
    protected SemesterSuggestionVO _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link SemesterSuggestionVO }
     *     
     */
    public SemesterSuggestionVO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link SemesterSuggestionVO }
     *     
     */
    public void setReturn(SemesterSuggestionVO value) {
        this._return = value;
    }

}
