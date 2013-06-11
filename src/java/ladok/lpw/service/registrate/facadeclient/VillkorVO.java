
package ladok.lpw.service.registrate.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for villkorVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="villkorVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meddelande" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meddelandeKod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "villkorVO", propOrder = {
    "meddelande",
    "meddelandeKod"
})
public class VillkorVO {

    protected String meddelande;
    protected String meddelandeKod;

    /**
     * Gets the value of the meddelande property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeddelande() {
        return meddelande;
    }

    /**
     * Sets the value of the meddelande property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeddelande(String value) {
        this.meddelande = value;
    }

    /**
     * Gets the value of the meddelandeKod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeddelandeKod() {
        return meddelandeKod;
    }

    /**
     * Sets the value of the meddelandeKod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeddelandeKod(String value) {
        this.meddelandeKod = value;
    }

}
