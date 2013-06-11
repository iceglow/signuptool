
package ladok.lpw.service.registrate.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for semesterRegistrationVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="semesterRegistrationVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anmkodPtill" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messages" type="{http://facadeclient.registrate.service.lpw.ladok/}message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="progbenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progbenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proginr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proginrbenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proginrbenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progterm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reg" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="regTill" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="regTyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urtabell" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="villkor" type="{http://facadeclient.registrate.service.lpw.ladok/}villkorVO" minOccurs="0"/>
 *         &lt;element name="villkor2" type="{http://facadeclient.registrate.service.lpw.ladok/}villkorVO" minOccurs="0"/>
 *         &lt;element name="villkor3" type="{http://facadeclient.registrate.service.lpw.ladok/}villkorVO" minOccurs="0"/>
 *         &lt;element name="webRegFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="webRegTill" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="webRegTom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "semesterRegistrationVO", propOrder = {
    "anmkodPtill",
    "messages",
    "progbenamn",
    "progbenamne",
    "proginr",
    "proginrbenamn",
    "proginrbenamne",
    "progr",
    "progterm",
    "reg",
    "regTill",
    "regTyp",
    "urtabell",
    "valid",
    "villkor",
    "villkor2",
    "villkor3",
    "webRegFrom",
    "webRegTill",
    "webRegTom"
})
public class SemesterRegistrationVO {

    protected String anmkodPtill;
    @XmlElement(nillable = true)
    protected List<Message> messages;
    protected String progbenamn;
    protected String progbenamne;
    protected String proginr;
    protected String proginrbenamn;
    protected String proginrbenamne;
    protected String progr;
    protected String progterm;
    protected boolean reg;
    protected boolean regTill;
    protected String regTyp;
    protected String urtabell;
    protected boolean valid;
    protected VillkorVO villkor;
    protected VillkorVO villkor2;
    protected VillkorVO villkor3;
    protected String webRegFrom;
    protected boolean webRegTill;
    protected String webRegTom;

    /**
     * Gets the value of the anmkodPtill property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnmkodPtill() {
        return anmkodPtill;
    }

    /**
     * Sets the value of the anmkodPtill property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnmkodPtill(String value) {
        this.anmkodPtill = value;
    }

    /**
     * Gets the value of the messages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Message }
     * 
     * 
     */
    public List<Message> getMessages() {
        if (messages == null) {
            messages = new ArrayList<Message>();
        }
        return this.messages;
    }

    /**
     * Gets the value of the progbenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgbenamn() {
        return progbenamn;
    }

    /**
     * Sets the value of the progbenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgbenamn(String value) {
        this.progbenamn = value;
    }

    /**
     * Gets the value of the progbenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgbenamne() {
        return progbenamne;
    }

    /**
     * Sets the value of the progbenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgbenamne(String value) {
        this.progbenamne = value;
    }

    /**
     * Gets the value of the proginr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProginr() {
        return proginr;
    }

    /**
     * Sets the value of the proginr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProginr(String value) {
        this.proginr = value;
    }

    /**
     * Gets the value of the proginrbenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProginrbenamn() {
        return proginrbenamn;
    }

    /**
     * Sets the value of the proginrbenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProginrbenamn(String value) {
        this.proginrbenamn = value;
    }

    /**
     * Gets the value of the proginrbenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProginrbenamne() {
        return proginrbenamne;
    }

    /**
     * Sets the value of the proginrbenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProginrbenamne(String value) {
        this.proginrbenamne = value;
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

    /**
     * Gets the value of the progterm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgterm() {
        return progterm;
    }

    /**
     * Sets the value of the progterm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgterm(String value) {
        this.progterm = value;
    }

    /**
     * Gets the value of the reg property.
     * 
     */
    public boolean isReg() {
        return reg;
    }

    /**
     * Sets the value of the reg property.
     * 
     */
    public void setReg(boolean value) {
        this.reg = value;
    }

    /**
     * Gets the value of the regTill property.
     * 
     */
    public boolean isRegTill() {
        return regTill;
    }

    /**
     * Sets the value of the regTill property.
     * 
     */
    public void setRegTill(boolean value) {
        this.regTill = value;
    }

    /**
     * Gets the value of the regTyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegTyp() {
        return regTyp;
    }

    /**
     * Sets the value of the regTyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegTyp(String value) {
        this.regTyp = value;
    }

    /**
     * Gets the value of the urtabell property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrtabell() {
        return urtabell;
    }

    /**
     * Sets the value of the urtabell property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrtabell(String value) {
        this.urtabell = value;
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

    /**
     * Gets the value of the villkor property.
     * 
     * @return
     *     possible object is
     *     {@link VillkorVO }
     *     
     */
    public VillkorVO getVillkor() {
        return villkor;
    }

    /**
     * Sets the value of the villkor property.
     * 
     * @param value
     *     allowed object is
     *     {@link VillkorVO }
     *     
     */
    public void setVillkor(VillkorVO value) {
        this.villkor = value;
    }

    /**
     * Gets the value of the villkor2 property.
     * 
     * @return
     *     possible object is
     *     {@link VillkorVO }
     *     
     */
    public VillkorVO getVillkor2() {
        return villkor2;
    }

    /**
     * Sets the value of the villkor2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link VillkorVO }
     *     
     */
    public void setVillkor2(VillkorVO value) {
        this.villkor2 = value;
    }

    /**
     * Gets the value of the villkor3 property.
     * 
     * @return
     *     possible object is
     *     {@link VillkorVO }
     *     
     */
    public VillkorVO getVillkor3() {
        return villkor3;
    }

    /**
     * Sets the value of the villkor3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link VillkorVO }
     *     
     */
    public void setVillkor3(VillkorVO value) {
        this.villkor3 = value;
    }

    /**
     * Gets the value of the webRegFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebRegFrom() {
        return webRegFrom;
    }

    /**
     * Sets the value of the webRegFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebRegFrom(String value) {
        this.webRegFrom = value;
    }

    /**
     * Gets the value of the webRegTill property.
     * 
     */
    public boolean isWebRegTill() {
        return webRegTill;
    }

    /**
     * Sets the value of the webRegTill property.
     * 
     */
    public void setWebRegTill(boolean value) {
        this.webRegTill = value;
    }

    /**
     * Gets the value of the webRegTom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebRegTom() {
        return webRegTom;
    }

    /**
     * Sets the value of the webRegTom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebRegTom(String value) {
        this.webRegTom = value;
    }

}
