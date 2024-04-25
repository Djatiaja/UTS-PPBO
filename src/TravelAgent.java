import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TravelAgent {
    ArrayList<Trip> listTrip = new ArrayList<>();

    public void addTrip(Trip trip){
        this.listTrip.add(trip);
    }

    public void showAvailableTrip(){
        int banyak =0;
        for (Trip trip: this.listTrip){
            if (trip.kuantiti>0){
                banyak++;
            }
        }
        if (banyak==0){
            System.out.println("Tidak ada trip yang tersedia");
        return;
        }
        System.out.println("Terdapat " + banyak + " yang masih tersedia");
        for (Trip trip:listTrip){
            if (trip.kuantiti > 0){
                System.out.println(trip);
            }
        }
    }

    public void bookTrip(Customer customer,Trip trip){
        if (trip.kuantiti <=0 ){
            System.out.println("Pemesanan gagal, perjalanan ke "+ trip.destinasi + " telah habis terjual");
            return;
        }
        if (validasiBooking(customer, trip)){
            System.out.println("Pemesanan gagal, pengguna telah memiliki pesanan pada trip yang sama dengan booking id " + trip.listBookingId.get(trip.listCustomer.indexOf(customer)));
            return;
        }
        trip.addCustomer(customer);
        trip.kuantiti --;
        System.out.println("Pemesanan berhasil dengan booking id " + trip.listBookingId.get(trip.listCustomer.indexOf(customer)));
    }

    private boolean validasiBooking(Customer customer, Trip trip){
        for (Customer customer1:trip.listCustomer){
            if (customer.equals(customer1)){
                return true;
            }
        }
        return false;
    }

    public void cancelBooking(String email, Trip trip){
        for (Customer customer:trip.listCustomer){
            if (customer.email.equals(email)){
                System.out.println("Pesanan dengan booking id " + trip.listBookingId.get(trip.listCustomer.indexOf(customer)) + " berhasil dibatalkan");
                trip.listBookingId.remove(trip.listBookingId.indexOf(trip.listBookingId.get(trip.listCustomer.indexOf(customer))));
                trip.listCustomer.remove(customer);
                trip.kuantiti ++;
                return;
            }
        }

    }

    public void getBookingsByCustomerEmail(String email){
        boolean empty=true;
        for (Trip trip: this.listTrip){
            for (Customer customer: trip.listCustomer){
                if (customer.email.equals(email)){
                    if (empty){
                        System.out.println("Pesanan dengan email "+ email);
                    }
                    empty=false;
                    System.out.println(( "Booking Id: "+trip.listBookingId.get(trip.listCustomer.indexOf(customer))+" Destinasi: " + trip.destinasi ));

                }
            }
        }
        if (empty){
            System.out.println("Tidak ditemukan untuk email "+ email);
        }
    }


    public void getAvailableTripsByType(TripType tripType){
        int banyak =0;
        for (Trip trip:this.listTrip){
            if (tripType.equals(trip.jenisTrip)){
                banyak++;
            }
        }
        if (banyak==0){
            System.out.println("Tidak ditemukan trip dengan jenis " + tripType);
            return;
        }
        System.out.println("Ditemukan " + banyak + " trip untuk jenis " + tripType  );
        for (Trip trip:this.listTrip){
            if (tripType.equals(trip.jenisTrip)){
                System.out.println(trip);
            }
        }
    }
    public void getAvailableTripsByDate(String tanggal){
        Date tanggalTrip;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            tanggalTrip = formatter.parse(tanggal);
        }catch (Exception err){
            System.out.println(err);
            return;
        }
        int banyak=0;
        for (Trip trip:this.listTrip){
            if (trip.tanggalKeberangkatan.equals(tanggalTrip)){
            banyak ++;
            };
        }
        if (banyak==0){
            System.out.println("Tidak ditemukan trip untuk tanggal " + tanggal);
            return;
        }
        System.out.println("Ditemukan " + banyak + " untuk keberangkatan tanggal " + tanggal);
        for (Trip trip:this.listTrip){
            if (trip.tanggalKeberangkatan.equals(tanggalTrip)){
                System.out.println(trip);
            };
        }
    }

}
