package kodlama.io2.rezervation.core.utilities.mappers;

import kodlama.io2.rezervation.business.requests.CreateReservationRequest;
import kodlama.io2.rezervation.entities.concretes.Reservation;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperService {
    private ModelMapper modelMapper;

    public ModelMapperService() {
        this.modelMapper = new ModelMapper();

        // CreateReservationRequest ile Reservation arasındaki eşlemeyi özelleştirme
        this.modelMapper.addMappings(new PropertyMap<CreateReservationRequest, Reservation>() {
            @Override
            protected void configure() {
                // carId ve customerId'nin Reservation'ın id alanına nasıl eşlendirileceğini belirt
                map().setId(source.getCarId()); // carId'yi id olarak ayarlıyoruz
                // Eğer customerId kullanmak isterseniz:
                // map().setId(source.getCustomerId());
            }
        });
    }

    public <S, D> D map(S source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }
}
