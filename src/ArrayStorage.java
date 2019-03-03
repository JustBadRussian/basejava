import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private static int arraySize;
    private Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < arraySize; i++) {
            storage[i] = null;
        }
        arraySize = 0;
    }

    void save(Resume r) {
        storage[arraySize] = r;
        arraySize++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < arraySize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < arraySize; i++) {
            if (storage[i].uuid.equals(uuid) && arraySize - i >= 0) {
                System.arraycopy(storage, i + 1, storage, i, arraySize - i);
                arraySize--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, arraySize);
    }

    int size() {
        return arraySize;
    }
}
