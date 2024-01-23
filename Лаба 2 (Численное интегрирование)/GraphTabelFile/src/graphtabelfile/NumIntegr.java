package graphtabelfile;

interface NumIntegr {
    double integr(double xMin, double xMax, int n);
}
class Integr_cr implements NumIntegr {
    public double integr(double xMin, double xMax, int n){
    //интегрирование по формуле «средняя точка прямоугольника»
        double dx =(xMax-xMin)/(n-1);
        double x,y,integr;
        integr=0.;
        
        for (int i = 1; i < n; i++){
            x = xMin + dx*(i-0.5);
            y = MyFunc.getMyFunc(x);
            integr += y*dx;
        }
        
        return integr;
    }
}
class Integr_lt implements NumIntegr {
    public double integr(double xMin, double xMax, int n){
    //интегрирование по формуле «левая точка прямоугольника»
        double dx =(xMax-xMin)/(n-1);
        double x, y, integr;
        integr = 0.;

        for (int i = 0; i < n - 1; i++) {
            x = xMin + dx * i;
            y = MyFunc.getMyFunc(x);
            integr += y * dx;
        }

        return integr;
    }
}
class Integr_rt implements NumIntegr {
    public double integr(double xMin, double xMax, int n){
    //интегрирование по формуле «правая точка прямоугольника»
        double dx =(xMax-xMin)/(n-1);
        double x, y, integr;
        integr = 0.;

        for (int i = 1; i < n; i++) {
            x = xMin + dx * i;
            y = MyFunc.getMyFunc(x);
            integr += y * dx;
        }

        return integr;
    }
}
class Integr_tr implements NumIntegr {
    public double integr(double xMin, double xMax, int n){
    //интегрирование по методу «трапеций»
        double dx = (xMax - xMin) / (n - 1);
        double x, y, integr;
        integr = 0.;

        for (int i = 0; i < n - 1; i++) {
            x = xMin + dx * i;
            y = MyFunc.getMyFunc(x);
            integr += (y + MyFunc.getMyFunc(x + dx)) * 0.5 * dx;
        }

        return integr;
    }
}
class Integr_simp implements NumIntegr {
    public double integr(double xMin, double xMax, int n){
    //интегрирование по формуле «Симпсона»
        double dx =(xMax-xMin)/(n-1); 
        double x,y,integr;
        integr=0.;
        for (int i = 1; i < n; i++){
          x = xMin + dx*(i-1);
          y = (MyFunc.getMyFunc(x)+4.*MyFunc.getMyFunc(x+0.5*dx)+MyFunc.getMyFunc(x+dx))/6.; 
          integr += y*dx;
        }
        return  integr; 
    }
}
class Integr_38 implements NumIntegr {
    public double integr(double xMin, double xMax, int n) {
    //интегрирование по формуле «3/8»
        double dx =(xMax-xMin)/(n-1); 
        double x,y,integr;
        integr=0.;
        for (int i = 1; i < n; i++){
          x = xMin + dx*(i-1);
          y = (MyFunc.getMyFunc(x)+3.*MyFunc.getMyFunc(x+dx/3.)+3.*MyFunc.getMyFunc(x+2.*dx/3.)+MyFunc.getMyFunc(x+dx))/8.; 
          integr += y*dx;
        }
        return  integr; 
    }
}
class Integr_gauss1 implements NumIntegr {
    public double integr(double xMin, double xMax, int n){
    //интегрирование по формуле «Гаусса, один узел»
        double dx = (xMax - xMin) / (n - 1);
        double x, y, integr, w1, e1;
        w1=1.; e1=0.;
        integr=0.;
        
        for (int i = 1; i < n; i++){
            x = xMin + dx * ( i - 0.5 ) + e1 * 0.5 * dx;
            y = MyFunc.getMyFunc(x);
            integr += w1 * y * dx;
        }
        
        return integr;
}}
class Integr_gauss2 implements NumIntegr {
   public double integr(double xMin, double xMax, int n){
   //интегрирование по формуле «Гаусса, два узла»
        double dx =(xMax-xMin)/(n-1); 
        double x1,x2,y,integr,w1,e1;
        e1=1./Math.sqrt(3.); 
        w1=0.5;
        integr=0.;
        for (int i = 1; i < n; i++){
          x1 = xMin + dx*(i-0.5)+ e1*0.5*dx;
          x2 = xMin + dx*(i-0.5)- e1*0.5*dx;
          y = w1*(MyFunc.getMyFunc(x1)+MyFunc.getMyFunc(x2)); 
          integr += y*dx;
        }
        return  integr; 
   }
}
class Integr_gauss3 implements NumIntegr {
    public double integr(double xMin, double xMax, int n){
    //интегрирование по формуле «Гаусса, три узла»
        double dx =(xMax-xMin)/(n-1); 
        double x1,x2,x0,y,integr,w1,w0,e1,e0;
        e0=0.;
        e1=Math.sqrt(15.)/5.; 
        w0=4./9.;
        w1=5./18.;
        integr=0.;
        for (int i = 1; i < n; i++){
          x0 = xMin + dx*(i-0.5)+ e0*0.5*dx;
          x1 = xMin + dx*(i-0.5)+ e1*0.5*dx;
          x2 = xMin + dx*(i-0.5)- e1*0.5*dx;
          y = w0*MyFunc.getMyFunc(x0)+w1*(MyFunc.getMyFunc(x1)+MyFunc.getMyFunc(x2)); 
          integr += y*dx;
        }
        return  integr; 
    }
}
