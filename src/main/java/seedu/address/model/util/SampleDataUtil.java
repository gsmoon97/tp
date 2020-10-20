package seedu.address.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.CliniCal;
import seedu.address.model.ReadOnlyCliniCal;
import seedu.address.model.allergy.Allergy;
import seedu.address.model.patient.Address;
import seedu.address.model.patient.BloodType;
import seedu.address.model.patient.Email;
import seedu.address.model.patient.IcNumber;
import seedu.address.model.patient.Name;
import seedu.address.model.patient.Patient;
import seedu.address.model.patient.Phone;
import seedu.address.model.patient.ProfilePicture;
import seedu.address.model.patient.Sex;
import seedu.address.model.tag.ColorTag;
import seedu.address.model.visit.Visit;
import seedu.address.model.visit.VisitHistory;

/**
 * Contains utility methods for populating {@code CliniCal} with sample data.
 */
public class SampleDataUtil {
    public static final VisitHistory EMPTY_VISIT_HISTORY = new VisitHistory(new ArrayList<Visit>());

    public static Patient[] getSamplePatients() {
        ProfilePicture profilePicture = new ProfilePicture("data/stock_picture.png");
        ColorTag placeholderColorTag = new ColorTag();

        return new Patient[] {
            new Patient(new Name("Alex Yeoh"), new Phone("87438807"), new IcNumber("S7908430A"), EMPTY_VISIT_HISTORY,
                    new Address("Blk 30 Geylang Street 29, #06-40"), new Email("alexyeoh@example.com"),
                    profilePicture, new Sex("M"), new BloodType("A+"),
                    getAllergySet("penicillin"), placeholderColorTag),
            new Patient(new Name("Bernice Yu"), new Phone("99272758"), new IcNumber("G4329854B"), EMPTY_VISIT_HISTORY,
                    new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), new Email("berniceyu@example.com"),
                    profilePicture, new Sex("F"), new BloodType("B+"),
                    getAllergySet("sulfa", "penicillin"), new ColorTag("maroon")),
            new Patient(new Name("Charlotte Oliveiro"), new Phone("93210283"), new IcNumber("S7856411C"),
                EMPTY_VISIT_HISTORY, new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                    new Email("charlotte@example.com"), profilePicture, new Sex("F"), new BloodType("O+"),
                    getAllergySet("sulfa"), placeholderColorTag),
            new Patient(new Name("David Li"), new Phone("91031282"), new IcNumber("F1155948D"), EMPTY_VISIT_HISTORY,
                    new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), new Email("lidavid@example.com"),
                    profilePicture, new Sex("M"), new BloodType("AB+"),
                    getAllergySet("aspirin"), placeholderColorTag),
            new Patient(new Name("Irfan Ibrahim"), new Phone("92492021"), new IcNumber("S1568938I"),
                EMPTY_VISIT_HISTORY, new Address("Blk 47 Tampines Street 20, #17-35"), new Email("irfan@example.com"),
                    profilePicture, new Sex("M"), new BloodType("A+"),
                    getAllergySet("aspirin", "sulfa"), placeholderColorTag),
            new Patient(new Name("Roy Balakrishnan"), new Phone("92624417"), new IcNumber("T9584423R"),
                EMPTY_VISIT_HISTORY, new Address("Blk 45 Aljunied Street 85, #11-31"), new Email("royb@example.com"),
                    profilePicture, new Sex("M"), new BloodType("O+"),
                    getAllergySet("penicillin"), placeholderColorTag),
        };
    }

    public static ReadOnlyCliniCal getSampleCliniCal() {
        CliniCal sampleAb = new CliniCal();
        for (Patient samplePatient : getSamplePatients()) {
            sampleAb.addPatient(samplePatient);
        }
        return sampleAb;
    }

    /**
     * Returns an allergy set containing the list of strings given.
     */
    public static Set<Allergy> getAllergySet(String... strings) {
        return Arrays.stream(strings)
                .map(Allergy::new)
                .collect(Collectors.toSet());
    }

}
