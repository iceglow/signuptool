
package ladok.lpw.service.register.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for regListEntVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="regListEntVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kursRegVOarr" type="{http://facadeclient.register.service.lpw.ladok/}kursRegVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="termRegVOarr" type="{http://facadeclient.register.service.lpw.ladok/}termRegVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="termin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="utbyteInregVO" type="{http://facadeclient.register.service.lpw.ladok/}utbyteInregVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="utbyteUtRegVOarr" type="{http://facadeclient.register.service.lpw.ladok/}utbyteUtRegVO" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "regListEntVO", propOrder = {
    "kursRegVOarr",
    "termRegVOarr",
    "termin",
    "utbyteInregVO",
    "utbyteUtRegVOarr",
    "valid"
})
public class RegListEntVO {

    @XmlElement(nillable = true)
    protected List<KursRegVO> kursRegVOarr;
    @XmlElement(nillable = true)
    protected List<TermRegVO> termRegVOarr;
    protected String termin;
    @XmlElement(nillable = true)
    protected List<UtbyteInregVO> utbyteInregVO;
    @XmlElement(nillable = true)
    protected List<UtbyteUtRegVO> utbyteUtRegVOarr;
    protected boolean valid;

    /**
     * Gets the value of the kursRegVOarr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kursRegVOarr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKursRegVOarr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KursRegVO }
     * 
     * 
     */
    public List<KursRegVO> getKursRegVOarr() {
        if (kursRegVOarr == null) {
            kursRegVOarr = new ArrayList<KursRegVO>();
        }
        return this.kursRegVOarr;
    }

    /**
     * Gets the value of the termRegVOarr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the termRegVOarr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTermRegVOarr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TermRegVO }
     * 
     * 
     */
    public List<TermRegVO> getTermRegVOarr() {
        if (termRegVOarr == null) {
            termRegVOarr = new ArrayList<TermRegVO>();
        }
        return this.termRegVOarr;
    }

    /**
     * Gets the value of the termin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermin() {
        return termin;
    }

    /**
     * Sets the value of the termin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermin(String value) {
        this.termin = value;
    }

    /**
     * Gets the value of the utbyteInregVO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the utbyteInregVO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUtbyteInregVO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UtbyteInregVO }
     * 
     * 
     */
    public List<UtbyteInregVO> getUtbyteInregVO() {
        if (utbyteInregVO == null) {
            utbyteInregVO = new ArrayList<UtbyteInregVO>();
        }
        return this.utbyteInregVO;
    }

    /**
     * Gets the value of the utbyteUtRegVOarr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the utbyteUtRegVOarr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUtbyteUtRegVOarr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UtbyteUtRegVO }
     * 
     * 
     */
    public List<UtbyteUtRegVO> getUtbyteUtRegVOarr() {
        if (utbyteUtRegVOarr == null) {
            utbyteUtRegVOarr = new ArrayList<UtbyteUtRegVO>();
        }
        return this.utbyteUtRegVOarr;
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
