import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private static int ARRAY_SIZE;

    private Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
        ARRAY_SIZE = 0;
    }

    void save(Resume r) {
        storage[size()] = r;
        ARRAY_SIZE++;
    }

    Resume get(String uuid) {

        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid))
                return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                if (size() - i >= 0) System.arraycopy(storage, i + 1, storage, i, size() - i);
                ARRAY_SIZE--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        return ARRAY_SIZE;
    }
}
