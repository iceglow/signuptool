
package ladok.lpw.service.register.facadeclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for utbyteInregVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="utbyteInregVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ansvinst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ansvinstBenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ansvinstBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="converted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="inst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kurs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kursBenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kursBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="land" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="landbenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="larare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="larareNamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="poang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provBenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provBenamne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="slutv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="termin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="univ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="univbenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uprog" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uprogbenamn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "utbyteInregVO", propOrder = {
    "ansvinst",
    "ansvinstBenamn",
    "ansvinstBenamne",
    "converted",
    "inst",
    "kurs",
    "kursBenamn",
    "kursBenamne",
    "land",
    "landbenamn",
    "larare",
    "larareNamn",
    "ort",
    "poang",
    "prov",
    "provBenamn",
    "provBenamne",
    "slutv",
    "startv",
    "termin",
    "type",
    "univ",
    "univbenamn",
    "uprog",
    "uprogbenamn"
})
public class UtbyteInregVO {

    protected String ansvinst;
    protected String ansvinstBenamn;
    protected String ansvinstBenamne;
    protected boolean converted;
    protected String inst;
    protected String kurs;
    protected String kursBenamn;
    protected String kursBenamne;
    protected String land;
    protected String landbenamn;
    protected String larare;
    protected String larareNamn;
    protected String ort;
    protected String poang;
    protected String prov;
    protected String provBenamn;
    protected String provBenamne;
    protected String slutv;
    protected String startv;
    protected String termin;
    protected String type;
    protected String univ;
    protected String univbenamn;
    protected String uprog;
    protected String uprogbenamn;

    /**
     * Gets the value of the ansvinst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnsvinst() {
        return ansvinst;
    }

    /**
     * Sets the value of the ansvinst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnsvinst(String value) {
        this.ansvinst = value;
    }

    /**
     * Gets the value of the ansvinstBenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnsvinstBenamn() {
        return ansvinstBenamn;
    }

    /**
     * Sets the value of the ansvinstBenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnsvinstBenamn(String value) {
        this.ansvinstBenamn = value;
    }

    /**
     * Gets the value of the ansvinstBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnsvinstBenamne() {
        return ansvinstBenamne;
    }

    /**
     * Sets the value of the ansvinstBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnsvinstBenamne(String value) {
        this.ansvinstBenamne = value;
    }

    /**
     * Gets the value of the converted property.
     * 
     */
    public boolean isConverted() {
        return converted;
    }

    /**
     * Sets the value of the converted property.
     * 
     */
    public void setConverted(boolean value) {
        this.converted = value;
    }

    /**
     * Gets the value of the inst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInst() {
        return inst;
    }

    /**
     * Sets the value of the inst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInst(String value) {
        this.inst = value;
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
     * Gets the value of the kursBenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKursBenamn() {
        return kursBenamn;
    }

    /**
     * Sets the value of the kursBenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKursBenamn(String value) {
        this.kursBenamn = value;
    }

    /**
     * Gets the value of the kursBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKursBenamne() {
        return kursBenamne;
    }

    /**
     * Sets the value of the kursBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKursBenamne(String value) {
        this.kursBenamne = value;
    }

    /**
     * Gets the value of the land property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLand() {
        return land;
    }

    /**
     * Sets the value of the land property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLand(String value) {
        this.land = value;
    }

    /**
     * Gets the value of the landbenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandbenamn() {
        return landbenamn;
    }

    /**
     * Sets the value of the landbenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandbenamn(String value) {
        this.landbenamn = value;
    }

    /**
     * Gets the value of the larare property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLarare() {
        return larare;
    }

    /**
     * Sets the value of the larare property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLarare(String value) {
        this.larare = value;
    }

    /**
     * Gets the value of the larareNamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLarareNamn() {
        return larareNamn;
    }

    /**
     * Sets the value of the larareNamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLarareNamn(String value) {
        this.larareNamn = value;
    }

    /**
     * Gets the value of the ort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrt() {
        return ort;
    }

    /**
     * Sets the value of the ort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrt(String value) {
        this.ort = value;
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
     * Gets the value of the prov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProv() {
        return prov;
    }

    /**
     * Sets the value of the prov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProv(String value) {
        this.prov = value;
    }

    /**
     * Gets the value of the provBenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvBenamn() {
        return provBenamn;
    }

    /**
     * Sets the value of the provBenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvBenamn(String value) {
        this.provBenamn = value;
    }

    /**
     * Gets the value of the provBenamne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvBenamne() {
        return provBenamne;
    }

    /**
     * Sets the value of the provBenamne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvBenamne(String value) {
        this.provBenamne = value;
    }

    /**
     * Gets the value of the slutv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlutv() {
        return slutv;
    }

    /**
     * Sets the value of the slutv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlutv(String value) {
        this.slutv = value;
    }

    /**
     * Gets the value of the startv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartv() {
        return startv;
    }

    /**
     * Sets the value of the startv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartv(String value) {
        this.startv = value;
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
     * Gets the value of the univ property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniv() {
        return univ;
    }

    /**
     * Sets the value of the univ property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniv(String value) {
        this.univ = value;
    }

    /**
     * Gets the value of the univbenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnivbenamn() {
        return univbenamn;
    }

    /**
     * Sets the value of the univbenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnivbenamn(String value) {
        this.univbenamn = value;
    }

    /**
     * Gets the value of the uprog property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUprog() {
        return uprog;
    }

    /**
     * Sets the value of the uprog property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUprog(String value) {
        this.uprog = value;
    }

    /**
     * Gets the value of the uprogbenamn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUprogbenamn() {
        return uprogbenamn;
    }

    /**
     * Sets the value of the uprogbenamn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUprogbenamn(String value) {
        this.uprogbenamn = value;
    }

}
