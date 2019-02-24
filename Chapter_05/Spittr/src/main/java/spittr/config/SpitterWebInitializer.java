package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spittr.web.WebConfig;

public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  /*
   * 扩展 AbstractAnnotationConfigDispatcherServletInitializer 的任意类，都会自动的配置 DispatcherServlet 和 Spring Application Context,
   * Spring Application Context 位于应用程序的 Servlet Context 之中。
   */


  // 创建 ContextLoaderListener （一个 Servlet 监听器）
  // ContextLoaderLister 加载应用中的其他 bean，驱动应用后端的中间层和数据层组件
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] { RootConfig.class };
  }


  // 创建 DispatcherServlet （front controller Servlet）, 单实例的Servlet将请求发送给 Spring MVC Controller
  // DispatcherServlet 加载包含 Web 组件的 bean，如 controller，view resolver 以及处理器映射
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { WebConfig.class };
  }


  // 将一个或者多个路径映射到 DispatcherServlet 上。
  // 本例中，它映射的是 "/"，表示它会是应用的默认 Servlet
  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}