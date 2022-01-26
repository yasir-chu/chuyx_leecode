package realization.stack;

/**
 * 使用栈模拟浏览器前进后退
 *
 * @author yuxiang.chu
 * @date 2022/1/26 10:33
 **/
public class BrowsTest {

    /**
     * 当前页面
     */
    public String nowPage;

    /**
     * 后退栈
     */
    public ListStack backStack;

    /**
     * 前进栈
     */
    public ListStack forwardStack;

    public BrowsTest() {
        this.backStack = new ListStack();
        this.forwardStack = new ListStack();
    }

    public static void main(String[] args) {

        BrowsTest browser = new BrowsTest();
        browser.newWeb("www.baidu.com");
        browser.newWeb("www.chuyx.top");
        System.out.println(browser.back());
        browser.newWeb("www.q1hang.com");
        System.out.println(browser.forward());
        System.out.println(browser.back());
        browser.newWeb("www.houlilian.com");
    }

    /**
     * 后退
     *
     * @return 后退页面url
     */
    public String back() {
        String pop = backStack.pop();
        if (pop == null) {
            return null;
        }
        forwardStack.push(pop);
        return pop;
    }

    /**
     * 开一个新页面
     *
     * @param url 页面url
     */
    public void newWeb(String url) {
        if (nowPage != null) {
            backStack.push(nowPage);
            forwardStack.clear();
        }
        nowPage = url;
    }

    /**
     * 前进
     *
     * @return 页面url
     */
    public String forward() {
        String pop = forwardStack.pop();
        if (pop == null) {
            return null;
        }
        backStack.push(pop);
        return pop;
    }
}
