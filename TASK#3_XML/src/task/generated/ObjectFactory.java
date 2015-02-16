package task.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class ObjectFactory {

    private final static QName _Bank_QNAME = new QName("", "bank");

    public ObjectFactory() {
    }

    public TypeBank createTypeBank() {
        return new TypeBank();
    }

    public TypeDepositeType createTypeDepositeType() {
        return new TypeDepositeType();
    }

    public TypeDeposite createTypeDeposite() {
        return new TypeDeposite();
    }

    public TypeDepositor createTypeDepositor() {
        return new TypeDepositor();
    }

    public JAXBElement<TypeBank> createBank(TypeBank value) {
        return new JAXBElement<TypeBank>(_Bank_QNAME, TypeBank.class, null, value);
    }

}
