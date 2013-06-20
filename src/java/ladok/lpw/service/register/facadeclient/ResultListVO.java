
package ladok.lpw.service.register.facadeclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for resultListVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resultListVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="avslutKurs" type="{http://facadeclient.register.service.lpw.ladok/}kursResVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bskala" type="{http://facadeclient.register.service.lpw.ladok/}bskalaVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="interships" type="{http://facadeclient.register.service.lpw.ladok/}internShipVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="messages" type="{http://facadeclient.register.service.lpw.ladok/}message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="numberOfErrors" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="oavslutKurs" type="{http://facadeclient.register.service.lpw.ladok/}kursResVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ovrProv" type="{http://facadeclient.register.service.lpw.ladok/}provResVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="praktik" type="{http://facadeclient.register.service.lpw.ladok/}praktikVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sumEcts" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="sumPoang" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="sumTGKurs" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="sumTGProv" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="tillgodo" type="{http://facadeclient.register.service.lpw.ladok/}tillgodoVO" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "resultListVO", propOrder = {
    "avslutKurs",
    "bskala",
    "interships",
    "messages",
    "numberOfErrors",
    "oavslutKurs",
    "ovrProv",
    "praktik",
    "sumEcts",
    "sumPoang",
    "sumTGKurs",
    "sumTGProv",
    "tillgodo",
    "valid"
})
public class ResultListVO {

    @XmlElement(nillable = true)
    protected List<KursResVO> avslutKurs;
    @XmlElement(nillable = true)
    protected List<BskalaVO> bskala;
    @XmlElement(nillable = true)
    protected List<InternShipVO> interships;
    @XmlElement(nillable = true)
    protected List<Message> messages;
    protected int numberOfErrors;
    @XmlElement(nillable = true)
    protected List<KursResVO> oavslutKurs;
    @XmlElement(nillable = true)
    protected List<ProvResVO> ovrProv;
    @XmlElement(nillable = true)
    protected List<PraktikVO> praktik;
    protected float sumEcts;
    protected float sumPoang;
    protected float sumTGKurs;
    protected float sumTGProv;
    @XmlElement(nillable = true)
    protected List<TillgodoVO> tillgodo;
    protected boolean valid;

    /**
     * Gets the value of the avslutKurs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the avslutKurs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvslutKurs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KursResVO }
     * 
     * 
     */
    public List<KursResVO> getAvslutKurs() {
        if (avslutKurs == null) {
            avslutKurs = new ArrayList<KursResVO>();
        }
        return this.avslutKurs;
    }

    /**
     * Gets the value of the bskala property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bskala property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBskala().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BskalaVO }
     * 
     * 
     */
    public List<BskalaVO> getBskala() {
        if (bskala == null) {
            bskala = new ArrayList<BskalaVO>();
        }
        return this.bskala;
    }

    /**
     * Gets the value of the interships property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interships property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInterships().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InternShipVO }
     * 
     * 
     */
    public List<InternShipVO> getInterships() {
        if (interships == null) {
            interships = new ArrayList<InternShipVO>();
        }
        return this.interships;
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
     * Gets the value of the numberOfErrors property.
     * 
     */
    public int getNumberOfErrors() {
        return numberOfErrors;
    }

    /**
     * Sets the value of the numberOfErrors property.
     * 
     */
    public void setNumberOfErrors(int value) {
        this.numberOfErrors = value;
    }

    /**
     * Gets the value of the oavslutKurs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oavslutKurs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOavslutKurs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KursResVO }
     * 
     * 
     */
    public List<KursResVO> getOavslutKurs() {
        if (oavslutKurs == null) {
            oavslutKurs = new ArrayList<KursResVO>();
        }
        return this.oavslutKurs;
    }

    /**
     * Gets the value of the ovrProv property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ovrProv property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOvrProv().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProvResVO }
     * 
     * 
     */
    public List<ProvResVO> getOvrProv() {
        if (ovrProv == null) {
            ovrProv = new ArrayList<ProvResVO>();
        }
        return this.ovrProv;
    }

    /**
     * Gets the value of the praktik property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the praktik property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPraktik().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PraktikVO }
     * 
     * 
     */
    public List<PraktikVO> getPraktik() {
        if (praktik == null) {
            praktik = new ArrayList<PraktikVO>();
        }
        return this.praktik;
    }

    /**
     * Gets the value of the sumEcts property.
     * 
     */
    public float getSumEcts() {
        return sumEcts;
    }

    /**
     * Sets the value of the sumEcts property.
     * 
     */
    public void setSumEcts(float value) {
        this.sumEcts = value;
    }

    /**
     * Gets the value of the sumPoang property.
     * 
     */
    public float getSumPoang() {
        return sumPoang;
    }

    /**
     * Sets the value of the sumPoang property.
     * 
     */
    public void setSumPoang(float value) {
        this.sumPoang = value;
    }

    /**
     * Gets the value of the sumTGKurs property.
     * 
     */
    public float getSumTGKurs() {
        return sumTGKurs;
    }

    /**
     * Sets the value of the sumTGKurs property.
     * 
     */
    public void setSumTGKurs(float value) {
        this.sumTGKurs = value;
    }

    /**
     * Gets the value of the sumTGProv property.
     * 
     */
    public float getSumTGProv() {
        return sumTGProv;
    }

    /**
     * Sets the value of the sumTGProv property.
     * 
     */
    public void setSumTGProv(float value) {
        this.sumTGProv = value;
    }

    /**
     * Gets the value of the tillgodo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tillgodo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTillgodo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TillgodoVO }
     * 
     * 
     */
    public List<TillgodoVO> getTillgodo() {
        if (tillgodo == null) {
            tillgodo = new ArrayList<TillgodoVO>();
        }
        return this.tillgodo;
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
