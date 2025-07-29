
package Models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Customer complex type.</p>
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="Customer">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <attribute name="idtfcl" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="titre" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="designation" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="adresse1" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="adresse2" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="codeVille" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="nomVille" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="paysAdresse" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="codePostal" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="categorie" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="dateNaissance" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="nationalite" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="agentEconomique" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="formeJuridique" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="marche" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="segment" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="sexe" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="niveauService" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="typeIdentCi" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="numeroIdentCi" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="statut" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="dateStatut" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Customer")
public class Customer {

    @XmlAttribute(name = "idtfcl", required = true)
    protected String idtfcl;
    @XmlAttribute(name = "titre", required = true)
    protected String titre;
    @XmlAttribute(name = "designation", required = true)
    protected String designation;
    @XmlAttribute(name = "adresse1", required = true)
    protected String adresse1;
    @XmlAttribute(name = "adresse2", required = true)
    protected String adresse2;
    @XmlAttribute(name = "codeVille", required = true)
    protected String codeVille;
    @XmlAttribute(name = "nomVille", required = true)
    protected String nomVille;
    @XmlAttribute(name = "paysAdresse", required = true)
    protected String paysAdresse;
    @XmlAttribute(name = "codePostal", required = true)
    protected String codePostal;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "categorie", required = true)
    protected String categorie;
    @XmlAttribute(name = "dateNaissance", required = true)
    protected String dateNaissance;
    @XmlAttribute(name = "nationalite", required = true)
    protected String nationalite;
    @XmlAttribute(name = "agentEconomique", required = true)
    protected String agentEconomique;
    @XmlAttribute(name = "formeJuridique", required = true)
    protected String formeJuridique;
    @XmlAttribute(name = "marche", required = true)
    protected String marche;
    @XmlAttribute(name = "segment", required = true)
    protected String segment;
    @XmlAttribute(name = "sexe", required = true)
    protected String sexe;
    @XmlAttribute(name = "niveauService", required = true)
    protected String niveauService;
    @XmlAttribute(name = "typeIdentCi", required = true)
    protected String typeIdentCi;
    @XmlAttribute(name = "numeroIdentCi", required = true)
    protected String numeroIdentCi;
    @XmlAttribute(name = "statut", required = true)
    protected String statut;
    @XmlAttribute(name = "dateStatut", required = true)
    protected String dateStatut;

    /**
     * Obtient la valeur de la propri�t� idtfcl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdtfcl() {
        return idtfcl;
    }

    /**
     * D�finit la valeur de la propri�t� idtfcl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdtfcl(String value) {
        this.idtfcl = value;
    }

    /**
     * Obtient la valeur de la propri�t� titre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitre() {
        return titre;
    }

    /**
     * D�finit la valeur de la propri�t� titre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitre(String value) {
        this.titre = value;
    }

    /**
     * Obtient la valeur de la propri�t� designation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * D�finit la valeur de la propri�t� designation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesignation(String value) {
        this.designation = value;
    }

    /**
     * Obtient la valeur de la propri�t� adresse1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresse1() {
        return adresse1;
    }

    /**
     * D�finit la valeur de la propri�t� adresse1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresse1(String value) {
        this.adresse1 = value;
    }

    /**
     * Obtient la valeur de la propri�t� adresse2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresse2() {
        return adresse2;
    }

    /**
     * D�finit la valeur de la propri�t� adresse2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresse2(String value) {
        this.adresse2 = value;
    }

    /**
     * Obtient la valeur de la propri�t� codeVille.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeVille() {
        return codeVille;
    }

    /**
     * D�finit la valeur de la propri�t� codeVille.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeVille(String value) {
        this.codeVille = value;
    }

    /**
     * Obtient la valeur de la propri�t� nomVille.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomVille() {
        return nomVille;
    }

    /**
     * D�finit la valeur de la propri�t� nomVille.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomVille(String value) {
        this.nomVille = value;
    }

    /**
     * Obtient la valeur de la propri�t� paysAdresse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaysAdresse() {
        return paysAdresse;
    }

    /**
     * D�finit la valeur de la propri�t� paysAdresse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaysAdresse(String value) {
        this.paysAdresse = value;
    }

    /**
     * Obtient la valeur de la propri�t� codePostal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * D�finit la valeur de la propri�t� codePostal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodePostal(String value) {
        this.codePostal = value;
    }

    /**
     * Obtient la valeur de la propri�t� type.
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
     * D�finit la valeur de la propri�t� type.
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
     * Obtient la valeur de la propri�t� categorie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     * D�finit la valeur de la propri�t� categorie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategorie(String value) {
        this.categorie = value;
    }

    /**
     * Obtient la valeur de la propri�t� dateNaissance.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateNaissance() {
        return dateNaissance;
    }

    /**
     * D�finit la valeur de la propri�t� dateNaissance.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateNaissance(String value) {
        this.dateNaissance = value;
    }

    /**
     * Obtient la valeur de la propri�t� nationalite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalite() {
        return nationalite;
    }

    /**
     * D�finit la valeur de la propri�t� nationalite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalite(String value) {
        this.nationalite = value;
    }

    /**
     * Obtient la valeur de la propri�t� agentEconomique.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentEconomique() {
        return agentEconomique;
    }

    /**
     * D�finit la valeur de la propri�t� agentEconomique.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentEconomique(String value) {
        this.agentEconomique = value;
    }

    /**
     * Obtient la valeur de la propri�t� formeJuridique.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormeJuridique() {
        return formeJuridique;
    }

    /**
     * D�finit la valeur de la propri�t� formeJuridique.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormeJuridique(String value) {
        this.formeJuridique = value;
    }

    /**
     * Obtient la valeur de la propri�t� marche.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarche() {
        return marche;
    }

    /**
     * D�finit la valeur de la propri�t� marche.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarche(String value) {
        this.marche = value;
    }

    /**
     * Obtient la valeur de la propri�t� segment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegment() {
        return segment;
    }

    /**
     * D�finit la valeur de la propri�t� segment.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegment(String value) {
        this.segment = value;
    }

    /**
     * Obtient la valeur de la propri�t� sexe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * D�finit la valeur de la propri�t� sexe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexe(String value) {
        this.sexe = value;
    }

    /**
     * Obtient la valeur de la propri�t� niveauService.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNiveauService() {
        return niveauService;
    }

    /**
     * D�finit la valeur de la propri�t� niveauService.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNiveauService(String value) {
        this.niveauService = value;
    }

    /**
     * Obtient la valeur de la propri�t� typeIdentCi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeIdentCi() {
        return typeIdentCi;
    }

    /**
     * D�finit la valeur de la propri�t� typeIdentCi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeIdentCi(String value) {
        this.typeIdentCi = value;
    }

    /**
     * Obtient la valeur de la propri�t� numeroIdentCi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroIdentCi() {
        return numeroIdentCi;
    }

    /**
     * D�finit la valeur de la propri�t� numeroIdentCi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroIdentCi(String value) {
        this.numeroIdentCi = value;
    }

    /**
     * Obtient la valeur de la propri�t� statut.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatut() {
        return statut;
    }

    /**
     * D�finit la valeur de la propri�t� statut.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatut(String value) {
        this.statut = value;
    }

    /**
     * Obtient la valeur de la propri�t� dateStatut.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateStatut() {
        return dateStatut;
    }

    /**
     * D�finit la valeur de la propri�t� dateStatut.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateStatut(String value) {
        this.dateStatut = value;
    }

}
