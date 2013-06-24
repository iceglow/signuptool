
package ladok.lpw.service.register.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for provResVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="provResVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="benamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="benamns" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="betyg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bskalaKod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ectsbet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ectsp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="intres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kurs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="not" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poangConverted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="projarb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="projarbe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provkod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provtyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tgSpecificering" type="{http://facadeclient.register.service.lpw.ladok/}tgSpecVO" minOccurs="0"/>
 *         &lt;element name="tgpoang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tgpoangConverted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "provResVO", propOrder = {
    "benamne",
    "benamns",
    "betyg",
    "bskalaKod",
    "ectsbet",
    "ectsp",
    "intres",
    "kurs",
    "not",
    "pnr",
    "poang",
    "poangConverted",
    "projarb",
    "projarbe",
    "provdat",
    "provkod",
    "provtyp",
    "tgSpecificering",
    "tgpoang",
    "tgpoangConverted"
})
public class ProvResVO {

    protected String benamne;
    protected String benamns;
    protected String betyg;
    protected String bskalaKod;
    protected String ectsbet;
    protected String ectsp;
    protected String intres;
    protected String kurs;
    protected int not;
    protected String pnr;
    protected String poang;
    protected boolean poangConverted;
    protected String projarb;
    protected String projarbe;
    protected String provdat;
    protected String provkod;
    protected String provtyp;
    protected TgSpecVO tgSpecificering;
    protected String tgpoang;
    protected boolean tgpoangConverted;

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
     * Gets the value of the betyg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBetyg() {
        return betyg;
    }

    /**
     * Sets the value of the betyg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBetyg(String value) {
        this.betyg = value;
    }

    /**
     * Gets the value of the bskalaKod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBskalaKod() {
        return bskalaKod;
    }

    /**
     * Sets the value of the bskalaKod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBskalaKod(String value) {
        this.bskalaKod = value;
    }

    /**
     * Gets the value of the ectsbet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEctsbet() {
        return ectsbet;
    }

    /**
     * Sets the value of the ectsbet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEctsbet(String value) {
        this.ectsbet = value;
    }

    /**
     * Gets the value of the ectsp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEctsp() {
        return ectsp;
    }

    /**
     * Sets the value of the ectsp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEctsp(String value) {
        this.ectsp = value;
    }

    /**
     * Gets the value of the intres property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntres() {
        return intres;
    }

    /**
     * Sets the value of the intres property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntres(String value) {
        this.intres = value;
    }

    /**
     * Gets the value of the kurs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKurs() {
        return kurs;
    }

    /**
     * Sets the value of the kurs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKurs(String value) {
        this.kurs = value;
    }

    /**
     * Gets the value of the not property.
     * 
     */
    public int getNot() {
        return not;
    }

    /**
     * Sets the value of the not property.
     * 
     */
    public void setNot(int value) {
        this.not = value;
    }

    /**
     * Gets the value of the pnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPnr() {
        return pnr;
    }

    /**
     * Sets the value of the pnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPnr(String value) {
        this.pnr = value;
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
     * Gets the value of the poangConverted property.
     * 
     */
    public boolean isPoangConverted() {
        return poangConverted;
    }

    /**
     * Sets the value of the poangConverted property.
     * 
     */
    public void setPoangConverted(boolean value) {
        this.poangConverted = value;
    }

    /**
     * Gets the value of the projarb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjarb() {
        return projarb;
    }

    /**
     * Sets the value of the projarb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjarb(String value) {
        this.projarb = value;
    }

    /**
     * Gets the value of the projarbe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjarbe() {
        return projarbe;
    }

    /**
     * Sets the value of the projarbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjarbe(String value) {
        this.projarbe = value;
    }

    /**
     * Gets the value of the provdat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvdat() {
        return provdat;
    }

    /**
     * Sets the value of the provdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvdat(String value) {
        this.provdat = value;
    }

    /**
     * Gets the value of the provkod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvkod() {
        return provkod;
    }

    /**
     * Sets the value of the provkod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvkod(String value) {
        this.provkod = value;
    }

    /**
     * Gets the value of the provtyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvtyp() {
        return provtyp;
    }

    /**
     * Sets the value of the provtyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvtyp(String value) {
        this.provtyp = value;
    }

    /**
     * Gets the value of the tgSpecificering property.
     * 
     * @return
     *     possible object is
     *     {@link TgSpecVO }
     *     
     */
    public TgSpecVO getTgSpecificering() {
        return tgSpecificering;
    }

    /**
     * Sets the value of the tgSpecificering property.
     * 
     * @param value
     *     allowed object is
     *     {@link TgSpecVO }
     *     
     */
    public void setTgSpecificering(TgSpecVO value) {
        this.tgSpecificering = value;
    }

    /**
     * Gets the value of the tgpoang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTgpoang() {
        return tgpoang;
    }

    /**
     * Sets the value of the tgpoang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTgpoang(String value) {
        this.tgpoang = value;
    }

    /**
     * Gets the value of the tgpoangConverted property.
     * 
     */
    public boolean isTgpoangConverted() {
        return tgpoangConverted;
    }

    /**
     * Sets the value of the tgpoangConverted property.
     * 
     */
    public void setTgpoangConverted(boolean value) {
        this.tgpoangConverted = value;
    }

}
