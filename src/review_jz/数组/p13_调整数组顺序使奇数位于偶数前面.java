package review_jz.数组;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author LiXiwen
 * @date 2020/1/19 13:22
 */
public class p13_调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        /*int[] a = {1,2,3,4,5,6,7,8,9};
        reOrderArray1(a);
        Arrays.stream(a).forEach(x -> System.out.print(x + " "));*/
        Manager manager = new Manager();
        manager.setAcademyId(1);
        if (null == manager.getAcademyId() || (null != manager.getSpecialtyId() ^ null != manager.getClassId())
                || (null != manager.getSpecialtyId() ^ null != manager.getGrade())) {
            System.out.println("aaaa");
        }
    }

    /**
     * 首尾指针，改变相对顺序
     * @param a
     */
    public static void reOrderArray(int[] a) {
        int l = 0;
        int h = a.length - 1;
        while (l < h) {
            while (l < h && !isOldNum(a[h])) {
                h--;
            }
            while (l < h && isOldNum(a[l])) {
                l++;
            }
            int t = a[l];
            a[l] = a[h];
            a[h] = t;
        }
    }

    /**
     * 快慢指针，改变顺序
     * @param a
     */
    public static void reOrderArray1(int[] a) {
        int l = 0;
        int f = 0;
        int n = a.length;
        while (f < n) {
            if ((a[f] & 1) == 1) {
                swap(a, l, f);
                l++;
            }
            f++;
        }
    }

    public static void swap(int[] a, int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

    private static boolean isOldNum(int num) {
        if ((num & 1) == 1) {
            return true;
        }
        return false;
    }

    /**
     * 调整数组元素顺序，使得奇数元素位于偶数元素前面，且保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param a 数组
     */
    public void reOrderArray4(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int c = 0;
        for (int x : a) {
            if (isOldNum(x)) {
                c++;
            }
        }
        int[] b = Arrays.copyOf(a, a.length);
        int i = 0;
        int j = c;
        for (int x : b) {
            if (isOldNum(x)) {
                a[i++] = x;
            } else {
                a[j++] = x;
            }
        }
    }

    public void reOrder(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }

    }

}

class Manager {

    private Integer systemId;

    // 学院 id
    private Integer academyId;

    // 专业 id
    private Integer specialtyId;

    // 班级 id
    private Integer classId;

    // 年级
    private String grade;

    // 用户名
    private String username;

    // 密码
    private String password;

    // A 管理员 | B 学院 | C 学生
    private String type;

    // token
    private String token;

    // false 无效 | true 有效
    private Boolean status;

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public Integer getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
