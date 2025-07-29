package Models;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class SoapClientFactory {

    public static ITransactionProcessor create() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ITransactionProcessor.class);

        // URL donnée dans ton document
        factory.setAddress("http://172.29.83.52:7801/position/v2/transactionProcessor");

        return (ITransactionProcessor) factory.create();
    }
}
