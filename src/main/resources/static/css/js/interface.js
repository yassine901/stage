// ================================================
// FICHIER JAVASCRIPT PRINCIPAL
// Fichier: src/main/resources/static/js/interface.js
// ================================================

// Variables globales
let transactionInProgress = false;
let startTime = null;

// Initialisation au chargement de la page
document.addEventListener('DOMContentLoaded', function() {
    initializeInterface();
    updateTimestamp();
    setInterval(updateTimestamp, 1000);

    // Event listeners
    document.getElementById('transactionForm').addEventListener('submit', handleFormSubmit);
    document.getElementById('compte').addEventListener('input', validateAccount);
    document.getElementById('amount').addEventListener('input', validateAmount);
    document.getElementById('user').addEventListener('input', validateUser);

    console.log('🚀 Interface initialisée - Configuration:', window.appConfig);
});

// ================================================
// INITIALISATION
// ================================================

function initializeInterface() {
    // Générer automatiquement une référence d'opération
    generateOperRef();

    // Mettre à jour le timestamp
    updateTimestamp();

    // Vérifier la connectivité avec l'API
    checkApiConnectivity();

    // Afficher les informations de configuration
    displayConfigInfo();
}

function displayConfigInfo() {
    console.log('📡 Configuration API:', {
        endpoint: window.appConfig?.defaultEndpoint || 'Non configuré',
        environment: window.appConfig?.environment || 'UNKNOWN',
        apiBase: window.appConfig?.apiBase || '/api'
    });
}

// ================================================
// GESTION DU TEMPS
// ================================================

function updateTimestamp() {
    const now = new Date();
    const timestamp = formatTimestamp(now);
    document.getElementById('timestamp').value = timestamp;
}

function formatTimestamp(date) {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    const hours = String(date.getHours()).padStart(2, '0');
    const minutes = String(date.getMinutes()).padStart(2, '0');
    const seconds = String(date.getSeconds()).padStart(2, '0');

    return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
}

// ================================================
// GÉNÉRATION AUTOMATIQUE
// ================================================

function generateOperRef() {
    const timestamp = Date.now();
    const random = Math.floor(Math.random() * 1000).toString().padStart(3, '0');
    const operRef = `WEB_${timestamp}_${random}`;
    document.getElementById('operRef').value = operRef;
    return operRef;
}

// ================================================
// VALIDATION DES CHAMPS
// ================================================

function validateAccount() {
    const account = document.getElementById('compte').value;
    const isValid = /^\d{15}$/.test(account);

    const input = document.getElementById('compte');
    if (isValid) {
        input.style.borderColor = 'var(--success-color)';
    } else {
        input.style.borderColor = account.length > 0 ? 'var(--error-color)' : '';
    }

    return isValid;
}

function validateAmount() {
    const amount = document.getElementById('amount').value;
    const amountValue = parseInt(amount);
    const isValid = !isNaN(amountValue) && amountValue > 0;

    const input = document.getElementById('amount');
    if (isValid) {
        input.style.borderColor = 'var(--success-color)';
        // Afficher la conversion en DH
        const dhAmount = (amountValue / 100).toFixed(2);
        input.title = `${dhAmount} DH`;
    } else {
        input.style.borderColor = amount.length > 0 ? 'var(--error-color)' : '';
        input.title = '';
    }

    return isValid;
}

function validateUser() {
    const user = document.getElementById('user').value;
    const isValid = user.trim().length > 0;

    const input = document.getElementById('user');
    input.style.borderColor = isValid ? 'var(--success-color)' : 'var(--error-color)';

    return isValid;
}

function validateForm() {
    const isAccountValid = validateAccount();
    const isAmountValid = validateAmount();
    const isUserValid = validateUser();
    const hasSignature = document.getElementById('signature').value.trim().length > 0;

    const allValid = isAccountValid && isAmountValid && isUserValid && hasSignature;

    // Mettre à jour le bouton d'exécution
    const executeBtn = document.getElementById('executeBtn');
    executeBtn.disabled = !allValid;

    if (allValid) {
        showAlert('✅ Tous les paramètres sont valides', 'success');
        executeBtn.textContent = '▶️ Exécuter Transaction';
        executeBtn.classList.remove('btn-secondary');
        executeBtn.classList.add('btn-primary');
    } else {
        const errors = [];
        if (!isAccountValid) errors.push('Compte invalide (15 chiffres requis)');
        if (!isAmountValid) errors.push('Montant invalide (doit être positif)');
        if (!isUserValid) errors.push('Utilisateur requis');
        if (!hasSignature) errors.push('Signature manquante');

        showAlert(`❌ Erreurs: ${errors.join(', ')}`, 'error');
        executeBtn.textContent = '❌ Paramètres invalides';
        executeBtn.classList.remove('btn-primary');
        executeBtn.classList.add('btn-secondary');
    }

    return allValid;
}

// ================================================
// GÉNÉRATION DE SIGNATURE VIA AJAX
// ================================================

async function generateSignatureAjax() {
    const canal = document.getElementById('canal').value;
    const user = document.getElementById('user').value;
    const timestamp = document.getElementById('timestamp').value;
    const account = document.getElementById('compte').value;

    // Validation préalable
    if (!user || !account || !timestamp) {
        showAlert('❌ Veuillez remplir tous les champs requis', 'error');
        return;
    }

    if (!validateAccount()) {
        showAlert('❌ Le numéro de compte doit contenir exactement 15 chiffres', 'error');
        return;
    }

    try {
        showSignatureStatus('⏳ Génération en cours...', 'info');

        const apiBase = window.appConfig?.apiBase || '/api';
        const response = await fetch(`${apiBase}/generate-signature`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: new URLSearchParams({
                canal: canal,
                user: user,
                timestamp: timestamp,
                account: account
            })
        });

        const result = await response.json();

        if (result.success) {
            document.getElementById('signature').value = result.signature;
            showSignatureStatus('✅ Signature générée avec succès', 'valid');
            showAlert('🔐 Signature générée avec succès!', 'success');

            // Activer la validation
            setTimeout(validateForm, 100);

        } else {
            showSignatureStatus('❌ Erreur: ' + result.message, 'invalid');
            showAlert('❌ Erreur: ' + result.error, 'error');
        }

    } catch (error) {
        console.error('Erreur génération signature:', error);
        showSignatureStatus('❌ Erreur de connexion', 'invalid');
        showAlert('❌ Erreur de connexion: ' + error.message, 'error');
    }
}

function showSignatureStatus(message, type) {
    const statusDiv = document.getElementById('signatureStatus');
    statusDiv.textContent = message;
    statusDiv.className = `signature-status ${type}`;
}

// ================================================
// EXÉCUTION DE TRANSACTION
// ================================================

function handleFormSubmit(event) {
    event.preventDefault();

    if (!validateForm()) {
        showAlert('❌ Veuillez corriger les erreurs avant de continuer', 'error');
        return;
    }

    executeTransaction();
}

async function executeTransaction() {
    if (transactionInProgress) {
        showAlert('⚠️ Une transaction est déjà en cours', 'warning');
        return;
    }

    transactionInProgress = true;
    startTime = Date.now();

    // Afficher la section de chargement
    showLoadingSection();

    // Construire la requête SOAP
    const soapRequest = buildSoapRequest();

    // Afficher la requête dans l'onglet
    document.getElementById('rawRequest').textContent = soapRequest;

    try {
        const endpoint = document.getElementById('endpoint').value;

        logTransaction('📤 Envoi de la requête vers: ' + endpoint);

        const response = await fetch(endpoint, {
            method: 'POST',
            headers: {
                'Content-Type': 'text/xml; charset=utf-8',
                'Accept': 'application/xml',
                'SOAPAction': 'processTransaction'
            },
            body: soapRequest
        });

        const responseText = await response.text();
        const responseTime = Date.now() - startTime;

        // Afficher la réponse
        document.getElementById('rawResponse').textContent = responseText;

        logTransaction('📥 Réponse reçue en ' + responseTime + 'ms');

        // Parser et afficher les résultats
        parseAndDisplayResponse(responseText, responseTime);

    } catch (error) {
        console.error('Erreur transaction:', error);
        const responseTime = Date.now() - startTime;

        logTransaction('❌ Erreur: ' + error.message);

        displayError(error.message, responseTime);

    } finally {
        transactionInProgress = false;
        hideLoadingSection();
        showResultSection();
    }
}

function buildSoapRequest() {
    const formData = {
        canal: document.getElementById('canal').value,
        user: document.getElementById('user').value,
        password: document.getElementById('password').value,
        signature: document.getElementById('signature').value,
        correlationId: document.getElementById('correlationId').value,
        timestamp: document.getElementById('timestamp').value,
        compte: document.getElementById('compte').value,
        amount: document.getElementById('amount').value,
        operRef: document.getElementById('operRef').value,
        ruleCode: document.getElementById('ruleCode').value
    };

    const currentDate = new Date().toISOString().slice(0,10).replace(/-/g,'');

    return `<?xml version="1.0" encoding="UTF-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
    <soap:Body>
        <operationExecReq xmlns="urn:schemas-attijariwafa-com:transaction-data">
            <ReqHeader canal="${formData.canal}" 
                       user="${formData.user}" 
                       password="${formData.password}" 
                       signature="${formData.signature}" 
                       correlationId="${formData.correlationId}" 
                       ts="${formData.timestamp}" 
                       replyFormat="FULL"/>
            <OperExeReq>
                <OperationData ruleCode="${formData.ruleCode}" 
                               operRef="${formData.operRef}" 
                               canal="${formData.canal}" 
                               operType="GOD01" 
                               operStatus="OCI" 
                               account="${formData.compte}" 
                               amount="${formData.amount}" 
                               sens="D" 
                               operDate="${currentDate}" 
                               valueDate="${currentDate}" 
                               endDate="${currentDate}" 
                               operLib="Transaction Interface Web" 
                               operLib2="Test Intégré" 
                               operLib3="Spring Boot" 
                               libCourt="WEBTEST"/>
            </OperExeReq>
        </operationExecReq>
    </soap:Body>
</soap:Envelope>`;
}

// ================================================
// AFFICHAGE DES RÉSULTATS
// ================================================

function parseAndDisplayResponse(xmlText, responseTime) {
    try {
        const parser = new DOMParser();
        const xmlDoc = parser.parseFromString(xmlText, "text/xml");

        // Extraire les données
        const returnCode = getXmlValue(xmlDoc, "ReturnCode") || "-";
        const errorCode = getXmlValue(xmlDoc, "ErrorCode") || "-";
        const message = getXmlValue(xmlDoc, "ReturnMessage") || "-";
        const newBalance = getXmlValue(xmlDoc, "NewAvailBal") || "-";
        const account = getXmlValue(xmlDoc, "Account") || "-";

        // Mettre à jour l'affichage
        document.getElementById('returnCode').textContent = returnCode;
        document.getElementById('errorCode').textContent = errorCode;
        document.getElementById('message').textContent = message;
        document.getElementById('newBalance').textContent = newBalance !== "-" ? formatBalance(newBalance) : "-";
        document.getElementById('responseTime').textContent = responseTime + " ms";
        document.getElementById('responseTimestamp').textContent = new Date().toLocaleString();

        // Mettre à jour le status card
        updateStatusCard(returnCode, errorCode, message);

        // Logger les résultats
        logTransaction(`📊 ReturnCode: ${returnCode}, ErrorCode: ${errorCode}`);
        logTransaction(`📝 Message: ${message}`);

        if (newBalance !== "-") {
            logTransaction(`💰 Nouveau solde: ${formatBalance(newBalance)}`);
        }

    } catch (error) {
        console.error('Erreur parsing XML:', error);
        logTransaction('❌ Erreur parsing XML: ' + error.message);
        displayError('Erreur lors de l\'analyse de la réponse', responseTime);
    }
}

function getXmlValue(xmlDoc, tagName) {
    const elements = xmlDoc.getElementsByTagName(tagName);
    return elements.length > 0 ? elements[0].textContent : null;
}

function updateStatusCard(returnCode, errorCode, message) {
    const statusCard = document.getElementById('statusCard');
    const statusIcon = document.getElementById('statusIcon');
    const statusTitle = document.getElementById('statusTitle');
    const statusMessage = document.getElementById('statusMessage');

    // Reset classes
    statusCard.className = 'status-card';

    if (returnCode === "0") {
        statusCard.classList.add('success');
        statusIcon.textContent = '✅';
        statusTitle.textContent = 'Transaction Réussie';
        statusMessage.textContent = message;
    } else {
        statusCard.classList.add('error');
        statusIcon.textContent = '❌';
        statusTitle.textContent = 'Transaction Échouée';
        statusMessage.textContent = `Erreur ${errorCode}: ${message}`;
    }
}

function displayError(errorMessage, responseTime) {
    // Afficher l'erreur dans les résultats
    document.getElementById('returnCode').textContent = "ERR";
    document.getElementById('errorCode').textContent = "CONN";
    document.getElementById('message').textContent = errorMessage;
    document.getElementById('newBalance').textContent = "-";
    document.getElementById('responseTime').textContent = responseTime + " ms";
    document.getElementById('responseTimestamp').textContent = new Date().toLocaleString();

    // Mettre à jour le status card pour erreur de connexion
    const statusCard = document.getElementById('statusCard');
    const statusIcon = document.getElementById('statusIcon');
    const statusTitle = document.getElementById('statusTitle');
    const statusMessage = document.getElementById('statusMessage');

    statusCard.className = 'status-card error';
    statusIcon.textContent = '🔌';
    statusTitle.textContent = 'Erreur de Connexion';
    statusMessage.textContent = errorMessage;
}

function formatBalance(centimes) {
    const dh = parseInt(centimes) / 100;
    return dh.toLocaleString('fr-FR', {
        minimumFractionDigits: 2,
        maximumFractionDigits: 2
    }) + ' DH';
}

// ================================================
// GESTION DES SECTIONS D'AFFICHAGE
// ================================================

function showLoadingSection() {
    document.getElementById('loadingSection').style.display = 'block';
    document.getElementById('resultSection').style.display = 'none';

    // Animation de la barre de progression
    const progressFill = document.getElementById('progressFill');
    let progress = 0;
    const interval = setInterval(() => {
        progress += Math.random() * 15;
        if (progress > 90) {
            clearInterval(interval);
            progress = 90;
        }
        progressFill.style.width = progress + '%';
    }, 200);

    // Stocker l'interval pour le nettoyer plus tard
    window.progressInterval = interval;
}

function hideLoadingSection() {
    document.getElementById('loadingSection').style.display = 'none';

    // Compléter la barre de progression
    const progressFill = document.getElementById('progressFill');
    progressFill.style.width = '100%';

    // Nettoyer l'interval
    if (window.progressInterval) {
        clearInterval(window.progressInterval);
    }
}

function showResultSection() {
    document.getElementById('resultSection').style.display = 'block';

    // Animation d'apparition
    const resultSection = document.getElementById('resultSection');
    resultSection.style.opacity = '0';
    resultSection.style.transform = 'translateY(20px)';

    setTimeout(() => {
        resultSection.style.transition = 'all 0.3s ease';
        resultSection.style.opacity = '1';
        resultSection.style.transform = 'translateY(0)';
    }, 100);
}

// ================================================
// GESTION DES ONGLETS
// ================================================

function showTab(event, tabId) {
    // Masquer tous les contenus d'onglets
    const tabContents = document.querySelectorAll('.tab-content');
    tabContents.forEach(content => content.classList.remove('active'));

    // Désactiver tous les onglets
    const tabs = document.querySelectorAll('.tab');
    tabs.forEach(tab => tab.classList.remove('active'));

    // Activer l'onglet cliqué
    event.target.classList.add('active');
    document.getElementById(tabId).classList.add('active');
}

// ================================================
// SYSTÈME DE LOGS
// ================================================

function logTransaction(message) {
    const timestamp = new Date().toLocaleTimeString();
    const logMessage = `[${timestamp}] ${message}`;

    console.log(logMessage);

    // Ajouter au conteneur de logs
    const logsContainer = document.getElementById('transactionLogs');
    const logEntry = document.createElement('div');
    logEntry.className = 'log-entry';
    logEntry.textContent = logMessage;

    logsContainer.appendChild(logEntry);
    logsContainer.scrollTop = logsContainer.scrollHeight;
}

// ================================================
// UTILITAIRES
// ================================================

function resetForm() {
    // Réinitialiser les champs
    document.getElementById('user').value = window.appConfig?.defaultUser || 'opvuser';
    document.getElementById('password').value = window.appConfig?.defaultPassword || 'pa123456';
    document.getElementById('compte').value = window.appConfig?.defaultAccount || '001234567890123';
    document.getElementById('amount').value = window.appConfig?.defaultAmount || '50000';
    document.getElementById('canal').value = 'OPMS';
    document.getElementById('ruleCode').value = 'RESER';
    document.getElementById('signature').value = '';

    // Générer nouveaux identifiants
    generateOperRef();
    updateTimestamp();

    // Masquer les résultats
    document.getElementById('resultSection').style.display = 'none';
    document.getElementById('loadingSection').style.display = 'none';

    // Réinitialiser la validation
    validateForm();

    // Effacer les logs
    document.getElementById('transactionLogs').innerHTML = '';

    showAlert('🔄 Formulaire réinitialisé', 'info');
}

function copyToClipboard(elementId) {
    const element = document.getElementById(elementId);
    const text = element.textContent;

    navigator.clipboard.writeText(text).then(() => {
        showAlert('📋 Contenu copié dans le presse-papiers', 'success');
    }).catch(err => {
        console.error('Erreur copie:', err);
        showAlert('❌ Erreur lors de la copie', 'error');
    });
}

async function checkApiConnectivity() {
    try {
        const apiBase = window.appConfig?.apiBase || '/api';
        const response = await fetch(`${apiBase}/system-info`);

        if (response.ok) {
            const info = await response.json();
            console.log('✅ API connectée:', info);
            showAlert('🌐 Connexion API établie', 'success');
        } else {
            throw new Error('API non accessible');
        }
    } catch (error) {
        console.warn('⚠️ API non accessible:', error.message);
        showAlert('⚠️ API non accessible en mode autonome', 'warning');
    }
}

// ================================================
// SYSTÈME D'ALERTES
// ================================================

function showAlert(message, type = 'info', duration = 5000) {
    // Créer l'élément d'alerte
    const alert = document.createElement('div');
    alert.className = `alert alert-${type}`;
    alert.textContent = message;

    // Ajouter un bouton de fermeture
    const closeBtn = document.createElement('button');
    closeBtn.textContent = '×';
    closeBtn.className = 'alert-close';
    closeBtn.onclick = () => alert.remove();
    alert.appendChild(closeBtn);

    // Ajouter au DOM
    const container = document.querySelector('.container');
    container.insertBefore(alert, container.firstChild);

    // Animation d'apparition
    alert.style.opacity = '0';
    alert.style.transform = 'translateY(-20px)';
    setTimeout(() => {
        alert.style.transition = 'all 0.3s ease';
        alert.style.opacity = '1';
        alert.style.transform = 'translateY(0)';
    }, 10);

    // Suppression automatique
    setTimeout(() => {
        if (alert.parentNode) {
            alert.style.opacity = '0';
            alert.style.transform = 'translateY(-20px)';
            setTimeout(() => alert.remove(), 300);
        }
    }, duration);
}

// ================================================
// FONCTIONS AVANCÉES
// ================================================

function exportResults() {
    const results = {
        timestamp: new Date().toISOString(),
        request: document.getElementById('rawRequest').textContent,
        response: document.getElementById('rawResponse').textContent,
        returnCode: document.getElementById('returnCode').textContent,
        errorCode: document.getElementById('errorCode').textContent,
        message: document.getElementById('message').textContent,
        newBalance: document.getElementById('newBalance').textContent,
        responseTime: document.getElementById('responseTime').textContent
    };

    const json = JSON.stringify(results, null, 2);
    const blob = new Blob([json], { type: 'application/json' });
    const url = URL.createObjectURL(blob);

    const a = document.createElement('a');
    a.href = url;
    a.download = `transaction_${Date.now()}.json`;
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
    URL.revokeObjectURL(url);

    showAlert('📁 Résultats exportés', 'success');
}

function importConfiguration(event) {
    const file = event.target.files[0];
    if (!file) return;

    const reader = new FileReader();
    reader.onload = function(e) {
        try {
            const config = JSON.parse(e.target.result);

            // Appliquer la configuration
            if (config.endpoint) document.getElementById('endpoint').value = config.endpoint;
            if (config.certificat) document.getElementById('certificat').value = config.certificat;
            if (config.user) document.getElementById('user').value = config.user;
            if (config.canal) document.getElementById('canal').value = config.canal;
            if (config.account) document.getElementById('compte').value = config.account;

            showAlert('⚙️ Configuration importée', 'success');
        } catch (error) {
            showAlert('❌ Erreur lors de l\'import: ' + error.message, 'error');
        }
    };
    reader.readAsText(file);
}

function saveConfiguration() {
    const config = {
        endpoint: document.getElementById('endpoint').value,
        certificat: document.getElementById('certificat').value,
        user: document.getElementById('user').value,
        canal: document.getElementById('canal').value,
        account: document.getElementById('compte').value,
        timestamp: new Date().toISOString()
    };

    const json = JSON.stringify(config, null, 2);
    const blob = new Blob([json], { type: 'application/json' });
    const url = URL.createObjectURL(blob);

    const a = document.createElement('a');
    a.href = url;
    a.download = 'transaction_config.json';
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
    URL.revokeObjectURL(url);

    showAlert('💾 Configuration sauvegardée', 'success');
}

// ================================================
// AUTO-COMPLETION ET SUGGESTIONS
// ================================================

function setupAutoComplete() {
    // Auto-complétion pour les utilisateurs
    const userSuggestions = ['opvuser', 'attiwmbjuser', 'testuser'];
    setupInputSuggestions('user', userSuggestions);

    // Auto-complétion pour les comptes de test
    const accountSuggestions = [
        '001234567890123',
        '987654321098765',
        '123456789012345'
    ];
    setupInputSuggestions('compte', accountSuggestions);
}

function setupInputSuggestions(inputId, suggestions) {
    const input = document.getElementById(inputId);

    input.addEventListener('focus', function() {
        showSuggestions(input, suggestions);
    });
}

function showSuggestions(input, suggestions) {
    // Créer une liste de suggestions
    const suggestionsDiv = document.createElement('div');
    suggestionsDiv.className = 'suggestions-list';
    suggestionsDiv.style.position = 'absolute';
    suggestionsDiv.style.background = 'white';
    suggestionsDiv.style.border = '1px solid var(--border-color)';
    suggestionsDiv.style.borderRadius = '5px';
    suggestionsDiv.style.maxHeight = '150px';
    suggestionsDiv.style.overflowY = 'auto';
    suggestionsDiv.style.zIndex = '1000';

    suggestions.forEach(suggestion => {
        const suggestionItem = document.createElement('div');
        suggestionItem.textContent = suggestion;
        suggestionItem.className = 'suggestion-item';
        suggestionItem.style.padding = '0.5rem';
        suggestionItem.style.cursor = 'pointer';
        suggestionItem.style.borderBottom = '1px solid #eee';

        suggestionItem.addEventListener('click', () => {
            input.value = suggestion;
            suggestionsDiv.remove();
            input.dispatchEvent(new Event('input'));
        });

        suggestionItem.addEventListener('mouseenter', () => {
            suggestionItem.style.background = 'var(--light-bg)';
        });

        suggestionItem.addEventListener('mouseleave', () => {
            suggestionItem.style.background = 'white';
        });

        suggestionsDiv.appendChild(suggestionItem);
    });

    // Positionner les suggestions
    const rect = input.getBoundingClientRect();
    suggestionsDiv.style.left = rect.left + 'px';
    suggestionsDiv.style.top = (rect.bottom + window.scrollY) + 'px';
    suggestionsDiv.style.width = rect.width + 'px';

    document.body.appendChild(suggestionsDiv);

    // Supprimer les suggestions si on clique ailleurs
    setTimeout(() => {
        document.addEventListener('click', function removeSuggestions(e) {
            if (!suggestionsDiv.contains(e.target) && e.target !== input) {
                suggestionsDiv.remove();
                document.removeEventListener('click', removeSuggestions);
            }
        });
    }, 100);
}

// ================================================
// RACCOURCIS CLAVIER
// ================================================

document.addEventListener('keydown', function(event) {
    // Ctrl+Enter: Exécuter la transaction
    if (event.ctrlKey && event.key === 'Enter') {
        event.preventDefault();
        if (!transactionInProgress) {
            executeTransaction();
        }
    }

    // Ctrl+G: Générer signature
    if (event.ctrlKey && event.key.toLowerCase() === 'g') {
        event.preventDefault();
        generateSignatureAjax();
    }

    // Ctrl+R: Réinitialiser (empêcher le rechargement de page)
    if (event.ctrlKey && event.key.toLowerCase() === 'r') {
        event.preventDefault();
        resetForm();
    }

    // F5: Actualiser timestamp
    if (event.key === 'F5') {
        event.preventDefault();
        updateTimestamp();
        showAlert('🕒 Timestamp actualisé', 'info');
    }
});

// ================================================
// MONITORING ET STATISTIQUES
// ================================================

let transactionStats = {
    total: 0,
    success: 0,
    errors: 0,
    startTime: Date.now()
};

function updateStats(success) {
    transactionStats.total++;
    if (success) {
        transactionStats.success++;
    } else {
        transactionStats.errors++;
    }

    // Mettre à jour l'affichage des stats si présent
    updateStatsDisplay();
}

function updateStatsDisplay() {
    const successRate = transactionStats.total > 0
        ? Math.round((transactionStats.success / transactionStats.total) * 100)
        : 0;

    console.log('📊 Statistiques:', {
        total: transactionStats.total,
        success: transactionStats.success,
        errors: transactionStats.errors,
        successRate: successRate + '%'
    });
}

// ================================================
// INITIALISATION AUTO-COMPLETION
// ================================================

// Initialiser l'auto-complétion après chargement
setTimeout(setupAutoComplete, 1000);

// ================================================
// EXPORT DES FONCTIONS GLOBALES
// ================================================

// Rendre les fonctions disponibles globalement pour les boutons
window.generateSignatureAjax = generateSignatureAjax;
window.executeTransaction = executeTransaction;
window.validateForm = validateForm;
window.resetForm = resetForm;
window.copyToClipboard = copyToClipboard;
window.showTab = showTab;
window.updateTimestamp = updateTimestamp;
window.generateOperRef = generateOperRef;
window.exportResults = exportResults;
window.saveConfiguration = saveConfiguration;