import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Trip {
String destinasi;
int hargaTrip, kuantiti;
private int counter;
Date tanggalKeberangkatan;


TripType jenisTrip;

ArrayList<Customer> listCustomer= new ArrayList<>();
ArrayList<String > listBookingId= new ArrayList<>();
Trip(String destinasi, int hargaTrip, String tanggalKeberangkatan, TripType jenisTrip, int kuantiti){
    this.destinasi = destinasi;
    this.hargaTrip = hargaTrip;
    try {
        this.tanggalKeberangkatan = new  SimpleDateFormat("dd-MMM-yyyy").parse(tanggalKeberangkatan);
    }catch (Exception err){
        System.out.println(err);
    }
    this.jenisTrip = jenisTrip;
    this.kuantiti = kuantiti;
}

    @Override
    public String toString() {
        return "Destinasi : " +this.destinasi
                + " -- Keberangkatan : " + this.tanggalKeberangkatan
                + " -- Harga : " + this.hargaTrip
                + " -- Qty : " +this.kuantiti
                + " -- Jenis : "+this.jenisTrip;
    }

    public void addCustomer(Customer customer){
    this.listCustomer.add(customer);
    this.listBookingId.add( "00" + this.destinasi + "00"+this.jenisTrip+counter );
    counter++;
    }
}
