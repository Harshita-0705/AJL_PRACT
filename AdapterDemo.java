interface USBCharger {
    void chargeWithUSB();
}
class MicroUSBCharger {
    void chargeWithMicroUSB() {
        System.out.println("Charging with Micro USB");
    }
}
class ChargerAdapter implements USBCharger {
    private MicroUSBCharger m;
    ChargerAdapter(MicroUSBCharger m) {
        this.m = m;
    }
    public void chargeWithUSB() {
        m.chargeWithMicroUSB();
    }
}
public class AdapterDemo {
    public static void main(String[] args) {
        USBCharger usbCharger = new ChargerAdapter(new MicroUSBCharger());
        usbCharger.chargeWithUSB();
    }
}