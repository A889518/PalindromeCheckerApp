import java.util.*;

class DNSEntry {
    String domain;
    String ipAddress;
    long expiryTime;

    DNSEntry(String domain, String ipAddress, int ttlSeconds) {
        this.domain = domain;
        this.ipAddress = ipAddress;
        this.expiryTime = System.currentTimeMillis() + (ttlSeconds * 1000);
    }

    boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}

class DNSCache {

    private LinkedHashMap<String, DNSEntry> cache;

    private int maxSize;
    private int hits = 0;
    private int misses = 0;

    DNSCache(int size) {
        this.maxSize = size;

        cache = new LinkedHashMap<String, DNSEntry>(size, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, DNSEntry> eldest) {
                return size() > maxSize;
            }
        };
    }

    private String queryUpstream(String domain) {

        if (domain.equals("google.com"))
            return "172.217.14.206";

        if (domain.equals("facebook.com"))
            return "157.240.22.35";

        return "192.168.1.1";
    }

    public String resolve(String domain) {

        long startTime = System.nanoTime();

        if (cache.containsKey(domain)) {

            DNSEntry entry = cache.get(domain);

            if (!entry.isExpired()) {
                hits++;
                long time = (System.nanoTime() - startTime) / 1000000;

                System.out.println("resolve(\"" + domain + "\") → Cache HIT → "
                        + entry.ipAddress + " (retrieved in " + time + " ms)");
                return entry.ipAddress;
            } else {
                System.out.println("resolve(\"" + domain + "\") → Cache EXPIRED");
                cache.remove(domain);
            }
        }

        misses++;

        String ip = queryUpstream(domain);

        System.out.println("Cache MISS → Query upstream → " + ip + " (TTL: 5s)");

        cache.put(domain, new DNSEntry(domain, ip, 5));

        return ip;
    }

    public void getCacheStats() {

        int total = hits + misses;

        double hitRate = total == 0 ? 0 : ((double) hits / total) * 100;

        System.out.println("Cache Stats:");
        System.out.println("Hits: " + hits);
        System.out.println("Misses: " + misses);
        System.out.println("Hit Rate: " + hitRate + "%");
    }
}

public class DNSCacheWithTTL {

    public static void main(String[] args) throws Exception {

        DNSCache dns = new DNSCache(3);

        dns.resolve("google.com");
        dns.resolve("google.com");

        Thread.sleep(6000);

        dns.resolve("google.com");

        dns.getCacheStats();
    }
}
