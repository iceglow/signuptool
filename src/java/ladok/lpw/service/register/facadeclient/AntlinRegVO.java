
package ladok.lpw.service.register.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for antlinRegVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="antlinRegVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="antInr" type="{http://facadeclient.register.service.lpw.ladok/}antinrRegVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="antTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="avbrDat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="avbrDnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="konvert" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "antlinRegVO", propOrder = {
    "antInr",
    "antTerm",
    "avbrDat",
    "avbrDnr",
    "benamne",
    "benamns",
    "konvert",
    "poang",
    "progr"
})
public class AntlinRegVO {

    @XmlElement(nillable = true)
    protected List<AntinrRegVO> antInr;
    protected String antTerm;
    protected String avbrDat;
    protected String avbrDnr;
    protected String benamne;
    protected String benamns;
    protected String konvert;
    protected String poang;
    protected String progr;

    /**
     * Gets the value of the antInr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the antInr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAntInr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AntinrRegVO }
     * 
     * 
     */
    public List<AntinrRegVO> getAntInr() {
        if (antInr == null) {
            antInr = new ArrayList<AntinrRegVO>();
        }
        return this.antInr;
    }

    /**
     * Gets the value of the antTerm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAntTerm() {
        return antTerm;
    }

    /**
     * Sets the value of the antTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAntTerm(String value) {
        this.antTerm = value;
    }

    /**
     * Gets the value of the avbrDat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvbrDat() {
        return avbrDat;
    }

    /**
     * Sets the value of the avbrDat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvbrDat(String value) {
        this.avbrDat = value;
    }

    /**
     * Gets the value of the avbrDnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvbrDnr() {
        return avbrDnr;
    }

    /**
     * Sets the value of the avbrDnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvbrDnr(String value) {
        this.avbrDnr = value;
    }

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
     * Gets the value of the konvert property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKonvert() {
        return konvert;
    }

    /**
     * Sets the value of the konvert property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKonvert(String value) {
        this.konvert = value;
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
     * Gets the value of the progr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgr() {
        return progr;
    }

    /**
     * Sets the value of the progr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgr(String value) {
        this.progr = value;
    }

}
