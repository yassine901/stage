
package Models;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour FundsTransferValidateReq complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="FundsTransferValidateReq">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReqHeader" type="{urn:schemas-attijariwafa-com:transaction-data}RequestHeader"/>
 *         <element name="FtValReq">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="Debit" type="{urn:schemas-attijariwafa-com:transaction-data}Operation"/>
 *                   <element name="Credits">
 *                     <complexType>
 *                       <complexContent>
 *                         <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           <sequence>
 *                             <element name="Credit" type="{urn:schemas-attijariwafa-com:transaction-data}Operation" maxOccurs="unbounded"/>
 *                           </sequence>
 *                         </restriction>
 *                       </complexContent>
 *                     </complexType>
 *                   </element>
 *                 </sequence>
 *                 <attribute name="trxType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="trxRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="accepterDepassement" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FundsTransferValidateReq", propOrder = {
    "reqHeader",
    "ftValReq"
})
public class FundsTransferValidateReq {

    @XmlElement(name = "ReqHeader", required = true)
    protected RequestHeader reqHeader;
    @XmlElement(name = "FtValReq", required = true)
    protected FundsTransferValidateReq.FtValReq ftValReq;

    /**
     * Obtient la valeur de la propri�t� reqHeader.
     * 
     * @return
     *     possible object is
     *     {@link RequestHeader }
     *     
     */
    public RequestHeader getReqHeader() {
        return reqHeader;
    }

    /**
     * D�finit la valeur de la propri�t� reqHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestHeader }
     *     
     */
    public void setReqHeader(RequestHeader value) {
        this.reqHeader = value;
    }

    /**
     * Obtient la valeur de la propri�t� ftValReq.
     * 
     * @return
     *     possible object is
     *     {@link FundsTransferValidateReq.FtValReq }
     *     
     */
    public FundsTransferValidateReq.FtValReq getFtValReq() {
        return ftValReq;
    }

    /**
     * D�finit la valeur de la propri�t� ftValReq.
     * 
     * @param value
     *     allowed object is
     *     {@link FundsTransferValidateReq.FtValReq }
     *     
     */
    public void setFtValReq(FundsTransferValidateReq.FtValReq value) {
        this.ftValReq = value;
    }


    /**
     * <p>Classe Java pour anonymous complex type.</p>
     * 
     * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="Debit" type="{urn:schemas-attijariwafa-com:transaction-data}Operation"/>
     *         <element name="Credits">
     *           <complexType>
     *             <complexContent>
     *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 <sequence>
     *                   <element name="Credit" type="{urn:schemas-attijariwafa-com:transaction-data}Operation" maxOccurs="unbounded"/>
     *                 </sequence>
     *               </restriction>
     *             </complexContent>
     *           </complexType>
     *         </element>
     *       </sequence>
     *       <attribute name="trxType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="trxRef" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="accepterDepassement" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "debit",
        "credits"
    })
    public static class FtValReq {

        @XmlElement(name = "Debit", required = true)
        protected Operation debit;
        @XmlElement(name = "Credits", required = true)
        protected FundsTransferValidateReq.FtValReq.Credits credits;
        @XmlAttribute(name = "trxType", required = true)
        protected String trxType;
        @XmlAttribute(name = "trxRef", required = true)
        protected String trxRef;
        @XmlAttribute(name = "accepterDepassement", required = true)
        protected String accepterDepassement;

        /**
         * Obtient la valeur de la propri�t� debit.
         * 
         * @return
         *     possible object is
         *     {@link Operation }
         *     
         */
        public Operation getDebit() {
            return debit;
        }

        /**
         * D�finit la valeur de la propri�t� debit.
         * 
         * @param value
         *     allowed object is
         *     {@link Operation }
         *     
         */
        public void setDebit(Operation value) {
            this.debit = value;
        }

        /**
         * Obtient la valeur de la propri�t� credits.
         * 
         * @return
         *     possible object is
         *     {@link FundsTransferValidateReq.FtValReq.Credits }
         *     
         */
        public FundsTransferValidateReq.FtValReq.Credits getCredits() {
            return credits;
        }

        /**
         * D�finit la valeur de la propri�t� credits.
         * 
         * @param value
         *     allowed object is
         *     {@link FundsTransferValidateReq.FtValReq.Credits }
         *     
         */
        public void setCredits(FundsTransferValidateReq.FtValReq.Credits value) {
            this.credits = value;
        }

        /**
         * Obtient la valeur de la propri�t� trxType.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTrxType() {
            return trxType;
        }

        /**
         * D�finit la valeur de la propri�t� trxType.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTrxType(String value) {
            this.trxType = value;
        }

        /**
         * Obtient la valeur de la propri�t� trxRef.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTrxRef() {
            return trxRef;
        }

        /**
         * D�finit la valeur de la propri�t� trxRef.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTrxRef(String value) {
            this.trxRef = value;
        }

        /**
         * Obtient la valeur de la propri�t� accepterDepassement.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccepterDepassement() {
            return accepterDepassement;
        }

        /**
         * D�finit la valeur de la propri�t� accepterDepassement.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccepterDepassement(String value) {
            this.accepterDepassement = value;
        }


        /**
         * <p>Classe Java pour anonymous complex type.</p>
         * 
         * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
         * 
         * <pre>{@code
         * <complexType>
         *   <complexContent>
         *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       <sequence>
         *         <element name="Credit" type="{urn:schemas-attijariwafa-com:transaction-data}Operation" maxOccurs="unbounded"/>
         *       </sequence>
         *     </restriction>
         *   </complexContent>
         * </complexType>
         * }</pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "credit"
        })
        public static class Credits {

            @XmlElement(name = "Credit", required = true)
            protected List<Operation> credit;

            /**
             * Gets the value of the credit property.
             * 
             * <p>This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the credit property.</p>
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * </p>
             * <pre>
             * getCredit().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Operation }
             * </p>
             * 
             * 
             * @return
             *     The value of the credit property.
             */
            public List<Operation> getCredit() {
                if (credit == null) {
                    credit = new ArrayList<>();
                }
                return this.credit;
            }

        }

    }

}
