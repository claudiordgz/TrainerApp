package com.mobileappscompany.android.trainerapplibrary.views.custom_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobileappscompany.android.trainerapplibrary.R;
import com.mobileappscompany.android.trainerapplibrary.common.DimensionConverter;


/**
 * Created by claudio on 11/02/15.
 */
public class TraineeHeader extends FrameLayout {

    private Context mContext;

    private TextView mTextViewFirstName;
    private TextView mTextViewLastName;
    private TextView mTextViewTechnology;
    private CircleImageView mCircleImageViewTraineeAvatar;


    private String mFirstNameStr;
    private String mLastNameStr;
    private String mTechnologyStr;
    private int mDrawableWidth;
    private int mBackgroundColor;
    private Drawable mAvatarDrawable;


    private int IMAGE_MARGIN = 16;
    private int DEFAULT_IMAGE_SIZE = 64;

    public TraineeHeader(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.custom_view_trainee_header, this);
    }

    public TraineeHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context, attrs);
    }

    public TraineeHeader(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        initViews(context, attrs);
    }

    private void initViews(Context context, AttributeSet attrs) {
        TypedArray layout = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.TraineeHeader, 0, 0);
        try {
            mFirstNameStr = layout.getString(R.styleable.TraineeHeader_first_name);
            mLastNameStr = layout.getString(R.styleable.TraineeHeader_last_name);
            mTechnologyStr = layout.getString(R.styleable.TraineeHeader_technology);
            mAvatarDrawable = layout.getDrawable(R.styleable.TraineeHeader_trainee_avatar);
            mDrawableWidth = layout.getDimensionPixelSize(R.styleable.TraineeHeader_trainee_avatar_width,
                    (int) DimensionConverter.convertDpToPixel(this.DEFAULT_IMAGE_SIZE, context));
            mBackgroundColor = layout.getColor(R.styleable.TraineeHeader_background_header, R.color.indigo_50);
        } finally {
            layout.recycle();
        }
        setAllVariables(context);

        // get Drawable information and get Width of CircleImageView
        mCircleImageViewTraineeAvatar.getLayoutParams().width = mDrawableWidth;
        mCircleImageViewTraineeAvatar.getLayoutParams().height = mDrawableWidth;
        int avatarWidth = mCircleImageViewTraineeAvatar.getLayoutParams().width;
        FrameLayout.LayoutParams imageParams =  new FrameLayout.LayoutParams(mCircleImageViewTraineeAvatar.getLayoutParams());

        // Set LayoutParameters for Image
        int imageMargin = (int)DimensionConverter.convertDpToPixel(this.IMAGE_MARGIN, context);
        imageParams.setMargins(imageMargin, imageMargin, 0, imageMargin);
        mCircleImageViewTraineeAvatar.setLayoutParams(imageParams);

        // Set LayoutParameters LinearLayout enclosing the Text
        LinearLayout linearLayoutNames = (LinearLayout)findViewById(R.id.text_fields_parent);
        FrameLayout.LayoutParams namesParams = new FrameLayout.LayoutParams(linearLayoutNames.getLayoutParams());
        int leftMargin = imageMargin*2 + avatarWidth;
        double topMargin = calculateTopMargin(imageMargin, mDrawableWidth);
        namesParams.setMargins(leftMargin, (int)topMargin, 0,0);
        linearLayoutNames.setLayoutParams(namesParams);

        // Add more top offset to bottom text
        LinearLayout.LayoutParams technologyParams = new LinearLayout.LayoutParams(mTextViewTechnology.getLayoutParams());
        technologyParams.setMargins(0, (int)(mDrawableWidth/2 * 0.7 /2), 0, 0);
        mTextViewTechnology.setLayoutParams(technologyParams);

    }


    private void setAllVariables(Context context) {
        LayoutInflater.from(context).inflate(R.layout.custom_view_trainee_header, this);
        mTextViewFirstName = (TextView)findViewById(R.id.text_field_first_name);
        mTextViewLastName = (TextView)findViewById(R.id.text_field_last_name);
        mTextViewTechnology = (TextView)findViewById(R.id.text_field_technology);
        mCircleImageViewTraineeAvatar = (CircleImageView)findViewById(R.id.trainee_avatar);
        setFirstName(mFirstNameStr);
        setLastName(mLastNameStr);
        setTechnology(mTechnologyStr);
        setTraineeAvatar(mAvatarDrawable);
        setBackgroundColor(mBackgroundColor);
        getBackground().setAlpha(255);

    }

    public String getFirstName() {
        return mFirstNameStr;
    }

    public void setFirstName(String firstName) {
        this.mFirstNameStr = firstName;
        if(mTextViewFirstName != null ){
            mTextViewFirstName.setText(firstName);
        }
    }

    public String getLastName() {
        return mLastNameStr;
    }

    public void setLastName(String lastName) {
        this.mLastNameStr = lastName;
        if(mTextViewLastName != null ){
            mTextViewLastName.setText(mLastNameStr);
        }
    }

    public String getTechnology() {
        return mTechnologyStr;
    }

    public void setTechnology(String technology) {
        this.mTechnologyStr = technology;
        if(mTextViewTechnology != null ){
            mTextViewTechnology.setText(mTechnologyStr);
        }
    }

    public Drawable getTraineeAvatar() {
        return mAvatarDrawable;
    }

    public void setTraineeAvatar(Drawable traineeAvatar) {
        this.mAvatarDrawable = traineeAvatar;
        if(mCircleImageViewTraineeAvatar != null){
            mCircleImageViewTraineeAvatar.setImageDrawable(mAvatarDrawable);
        }
    }

    private double calculateTopMargin(double avatarTopMargin, double height) {
        double topMargin = (height/2) * 0.3;
        return avatarTopMargin + topMargin;
    }
}
