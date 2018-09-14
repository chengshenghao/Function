package com.csh.function.utils;


import com.csh.function.R;

/**
 * 描述:根据id获取图片资源
 *
 * @author wjx
 * @date 2018/6/14 14:27
 */
public class ImgUtils {
    public static int getImage(int id) {
        switch (id) {
            case 1://加单
                return R.drawable.ic_fun_plus;
            case 2://结算
                return R.drawable.ic_fun_pay;
            case 3://赠单
                return R.drawable.ic_fun_gift;
            case 4://退单
                return R.drawable.ic_fun_cancel;
            case 5: //更换客位
                return R.drawable.ic_fun_change;
            case 6://修改开单
                return R.drawable.ic_fun_users;
            case 7://称重
                return R.drawable.ic_fun_weight;
            case 8://打印
                return R.drawable.ic_fun_print;
            case 9://关账
                return R.drawable.ic_fun_close;
            case 10://催单
                return R.drawable.ic_fun_bell;
            case 11://起菜
                return R.drawable.ic_fun_qicai;
            case 12://单品转台
                return R.drawable.ic_fun_danpinzhuantai;
            case 13://上菜
                return R.drawable.ic_fun_shangcai;
            case 14://并账
                return R.drawable.ic_fun_bingzhang;
            default:
                return R.drawable.ic_fun_bell;
        }
    }
}
