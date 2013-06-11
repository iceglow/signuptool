
package ladok.lpw.service.registrate.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for personVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="personVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annanid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="avliden" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emailadr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="facknr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fcoadr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fgatadr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fland" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fpostnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gallrad" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="gallradDatum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="konto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sekel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sms" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tcoadr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tgatadr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tland" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tnamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tomdat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tpostnr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personVO", propOrder = {
    "annanid",
    "avliden",
    "emailadr",
    "enamn",
    "facknr",
    "fcoadr",
    "fgatadr",
    "fland",
    "fort",
    "fpostnr",
    "fromdat",
    "gallrad",
    "gallradDatum",
    "konto",
    "pnr",
    "sekel",
    "sms",
    "tcoadr",
    "telnr",
    "tgatadr",
    "tland",
    "tnamn",
    "tomdat",
    "tort",
    "tpostnr"
})
public class PersonVO {

    protected String annanid;
    protected String avliden;
    protected String emailadr;
    protected String enamn;
    protected String facknr;
    protected String fcoadr;
    protected String fgatadr;
    protected String fland;
    protected String fort;
    protected String fpostnr;
    protected String fromdat;
    protected boolean gallrad;
    protected String gallradDatum;
    protected String konto;
    protected String pnr;
    protected String sekel;
    protected String sms;
    protected String tcoadr;
    protected String telnr;
    protected String tgatadr;
    protected String tland;
    protected String tnamn;
    protected String tomdat;
    protected String tort;
    protected String tpostnr;

    /**
     * Gets the value of the annanid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnanid() {
        return annanid;
    }

    /**
     * Sets the value of the annanid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnanid(String value) {
        this.annanid = value;
    }

    /**
     * Gets the value of the avliden property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvliden() {
        return avliden;
    }

    /**
     * Sets the value of the avliden property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvliden(String value) {
        this.avliden = value;
    }

    /**
     * Gets the value of the emailadr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailadr() {
        return emailadr;
    }

    /**
     * Sets the value of the emailadr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailadr(String value) {
        this.emailadr = value;
    }

    /**
     * Gets the value of the enamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnamn() {
        return enamn;
    }

    /**
     * Sets the value of the enamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnamn(String value) {
        this.enamn = value;
    }

    /**
     * Gets the value of the facknr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacknr() {
        return facknr;
    }

    /**
     * Sets the value of the facknr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacknr(String value) {
        this.facknr = value;
    }

    /**
     * Gets the value of the fcoadr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcoadr() {
        return fcoadr;
    }

    /**
     * Sets the value of the fcoadr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcoadr(String value) {
        this.fcoadr = value;
    }

    /**
     * Gets the value of the fgatadr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFgatadr() {
        return fgatadr;
    }

    /**
     * Sets the value of the fgatadr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFgatadr(String value) {
        this.fgatadr = value;
    }

    /**
     * Gets the value of the fland property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFland() {
        return fland;
    }

    /**
     * Sets the value of the fland property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFland(String value) {
        this.fland = value;
    }

    /**
     * Gets the value of the fort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFort() {
        return fort;
    }

    /**
     * Sets the value of the fort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFort(String value) {
        this.fort = value;
    }

    /**
     * Gets the value of the fpostnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFpostnr() {
        return fpostnr;
    }

    /**
     * Sets the value of the fpostnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFpostnr(String value) {
        this.fpostnr = value;
    }

    /**
     * Gets the value of the fromdat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromdat() {
        return fromdat;
    }

    /**
     * Sets the value of the fromdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromdat(String value) {
        this.fromdat = value;
    }

    /**
     * Gets the value of the gallrad property.
     * 
     */
    public boolean isGallrad() {
        return gallrad;
    }

    /**
     * Sets the value of the gallrad property.
     * 
     */
    public void setGallrad(boolean value) {
        this.gallrad = value;
    }

    /**
     * Gets the value of the gallradDatum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGallradDatum() {
        return gallradDatum;
    }

    /**
     * Sets the value of the gallradDatum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGallradDatum(String value) {
        this.gallradDatum = value;
    }

    /**
     * Gets the value of the konto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKonto() {
        return konto;
    }

    /**
     * Sets the value of the konto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKonto(String value) {
        this.konto = value;
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
     * Gets the value of the sekel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSekel() {
        return sekel;
    }

    /**
     * Sets the value of the sekel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSekel(String value) {
        this.sekel = value;
    }

    /**
     * Gets the value of the sms property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSms() {
        return sms;
    }

    /**
     * Sets the value of the sms property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSms(String value) {
        this.sms = value;
    }

    /**
     * Gets the value of the tcoadr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTcoadr() {
        return tcoadr;
    }

    /**
     * Sets the value of the tcoadr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTcoadr(String value) {
        this.tcoadr = value;
    }

    /**
     * Gets the value of the telnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelnr() {
        return telnr;
    }

    /**
     * Sets the value of the telnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelnr(String value) {
        this.telnr = value;
    }

    /**
     * Gets the value of the tgatadr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTgatadr() {
        return tgatadr;
    }

    /**
     * Sets the value of the tgatadr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTgatadr(String value) {
        this.tgatadr = value;
    }

    /**
     * Gets the value of the tland property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTland() {
        return tland;
    }

    /**
     * Sets the value of the tland property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTland(String value) {
        this.tland = value;
    }

    /**
     * Gets the value of the tnamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTnamn() {
        return tnamn;
    }

    /**
     * Sets the value of the tnamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTnamn(String value) {
        this.tnamn = value;
    }

    /**
     * Gets the value of the tomdat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTomdat() {
        return tomdat;
    }

    /**
     * Sets the value of the tomdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTomdat(String value) {
        this.tomdat = value;
    }

    /**
     * Gets the value of the tort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTort() {
        return tort;
    }

    /**
     * Sets the value of the tort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTort(String value) {
        this.tort = value;
    }

    /**
     * Gets the value of the tpostnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpostnr() {
        return tpostnr;
    }

    /**
     * Sets the value of the tpostnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpostnr(String value) {
        this.tpostnr = value;
    }

}
