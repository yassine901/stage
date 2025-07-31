// transaction-interface.js
// Modern JS for Attijariwafa Bank Transaction Interface

// Helper: Update timestamp field to current ISO string
function updateTimestamp() {
    const tsInput = document.getElementById('timestamp');
    const now = new Date();
    tsInput.value = now.toISOString().slice(0, 19).replace('T', ' ');
}

document.addEventListener('DOMContentLoaded', () => {
    updateTimestamp();
    // Enable execute button only if signature is present
    const signatureInput = document.getElementById('signature');
    const executeBtn = document.getElementById('executeBtn');
    if (signatureInput && executeBtn) {
        signatureInput.addEventListener('input', () => {
            executeBtn.disabled = !signatureInput.value;
        });
    }
});

// Generate signature via backend (AJAX)
function generateSignatureAjax() {
    const canal = 'WEB';
    const user = document.getElementById('user').value;
    const timestamp = document.getElementById('timestamp').value;
    const account = document.getElementById('compte').value;
    fetch(`/position/v2/generate-test-signature?canal=${encodeURIComponent(canal)}&user=${encodeURIComponent(user)}&timestamp=${encodeURIComponent(timestamp)}&account=${encodeURIComponent(account)}`)
        .then(res => res.json())
        .then(data => {
            document.getElementById('signature').value = data.signature || '';
            document.getElementById('signatureStatus').textContent = 'Signature générée';
            document.getElementById('signatureStatus').className = 'signature-status valid';
            document.getElementById('executeBtn').disabled = !data.signature;
        })
        .catch(() => {
            document.getElementById('signatureStatus').textContent = 'Erreur génération signature';
            document.getElementById('signatureStatus').className = 'signature-status invalid';
        });
}

// Manual regenerate operation reference
function manualRegenerateOperRef() {
    const ref = 'OPER_' + Math.random().toString(36).substr(2, 8).toUpperCase();
    document.getElementById('operRef').value = ref;
    document.getElementById('operRefStatus').classList.remove('hidden');
    document.getElementById('operRefMessage').textContent = 'Référence régénérée';
}

// Validate form fields
function validateForm() {
    let valid = true;
    const requiredFields = ['endpoint', 'user', 'password', 'correlationId', 'timestamp', 'compte', 'amount', 'operRef', 'ruleCode', 'signature'];
    requiredFields.forEach(id => {
        const el = document.getElementById(id);
        if (!el.value) {
            el.classList.add('error-text');
            valid = false;
        } else {
            el.classList.remove('error-text');
        }
    });
    if (valid) {
        alert('Tous les champs sont valides.');
    } else {
        alert('Veuillez remplir tous les champs obligatoires.');
    }
}

// Reset form
function resetForm() {
    document.getElementById('transactionForm').reset();
    updateTimestamp();
    document.getElementById('signature').value = '';
    document.getElementById('signatureStatus').textContent = '';
    document.getElementById('executeBtn').disabled = true;
}

// Execute transaction (AJAX)
function executeTransaction() {
    const endpoint = document.getElementById('endpoint').value;
    const user = document.getElementById('user').value;
    const password = document.getElementById('password').value;
    const correlationId = document.getElementById('correlationId').value;
    const timestamp = document.getElementById('timestamp').value;
    const compte = document.getElementById('compte').value;
    const amount = document.getElementById('amount').value;
    const operRef = document.getElementById('operRef').value;
    const ruleCode = document.getElementById('ruleCode').value;
    const signature = document.getElementById('signature').value;

    // Build SOAP XML (simplified for demo)
    const soapBody = `<?xml version="1.0" encoding="UTF-8"?>\n<operationExecReq>\n  <ReqHeader canal="WEB" user="${user}" password="${password}" signature="${signature}" correlationId="${correlationId}" ts="${timestamp}" replyFormat="FULL"/>\n  <OperExeReq>\n    <OperationData ruleCode="${ruleCode}" operRef="${operRef}" canal="WEB" operType="GOD01" operStatus="OCI" account="${compte}" amount="${amount}" sens="D" operDate="${timestamp.replace(/[- :]/g, '').slice(0,8)}" valueDate="${timestamp.replace(/[- :]/g, '').slice(0,8)}" endDate="${timestamp.replace(/[- :]/g, '').slice(0,8)}" operLib="GOD SOUSCRIPTION" operLib2="" operLib3="" libCourt="VGSINST" recorded="N"/>\n  </OperExeReq>\n</operationExecReq>`;

    document.getElementById('rawRequest').textContent = soapBody;
    document.getElementById('resultSection').style.display = 'block';
    document.getElementById('statusTitle').textContent = 'Envoi en cours...';
    document.getElementById('statusMessage').textContent = 'Transaction en cours de traitement...';
    document.getElementById('statusIcon').innerHTML = '<i class="fas fa-spinner fa-spin"></i>';

    fetch(endpoint, {
        method: 'POST',
        headers: { 'Content-Type': 'application/xml' },
        body: soapBody
    })
    .then(res => res.text())
    .then(response => {
        document.getElementById('rawResponse').textContent = response;
        document.getElementById('statusTitle').textContent = 'Réponse reçue';
        document.getElementById('statusMessage').textContent = 'Voir l’onglet Réponse.';
        document.getElementById('statusIcon').innerHTML = '<i class="fas fa-check-circle" style="color: #27ae60;"></i>';
        // Optionally parse XML and update result fields
    })
    .catch(() => {
        document.getElementById('statusTitle').textContent = 'Erreur';
        document.getElementById('statusMessage').textContent = 'Erreur lors de l’envoi de la transaction.';
        document.getElementById('statusIcon').innerHTML = '<i class="fas fa-times-circle" style="color: #e74c3c;"></i>';
    });
}

// Tab switching
function showTab(event, tabId) {
    document.querySelectorAll('.tab').forEach(tab => tab.classList.remove('active'));
    document.querySelectorAll('.tab-content').forEach(tc => tc.classList.remove('active'));
    event.currentTarget.classList.add('active');
    document.getElementById(tabId).classList.add('active');
}

// Copy to clipboard
function copyToClipboard(elementId) {
    const el = document.getElementById(elementId);
    if (el) {
        navigator.clipboard.writeText(el.textContent).then(() => {
            alert('Copié dans le presse-papiers!');
        });
    }
}