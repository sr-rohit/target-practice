<?php
return array (
  'scopes' => 
  array (
    'websites' => 
    array (
      'admin' => 
      array (
        'website_id' => '0',
        'code' => 'admin',
        'name' => 'Admin',
        'sort_order' => '0',
        'default_group_id' => '0',
        'is_default' => '0',
      ),
      'base' => 
      array (
        'website_id' => '1',
        'code' => 'base',
        'name' => 'Main Website',
        'sort_order' => '0',
        'default_group_id' => '1',
        'is_default' => '1',
      ),
    ),
    'groups' => 
    array (
      0 => 
      array (
        'group_id' => '0',
        'website_id' => '0',
        'name' => 'Default',
        'root_category_id' => '0',
        'default_store_id' => '0',
      ),
      1 => 
      array (
        'group_id' => '1',
        'website_id' => '1',
        'name' => 'Main Website Store',
        'root_category_id' => '2',
        'default_store_id' => '1',
      ),
    ),
    'stores' => 
    array (
      'admin' => 
      array (
        'store_id' => '0',
        'code' => 'admin',
        'website_id' => '0',
        'group_id' => '0',
        'name' => 'Admin',
        'sort_order' => '0',
        'is_active' => '1',
      ),
      'default' => 
      array (
        'store_id' => '1',
        'code' => 'default',
        'website_id' => '1',
        'group_id' => '1',
        'name' => 'Default Store View',
        'sort_order' => '0',
        'is_active' => '1',
      ),
    ),
  ),
  /**
   * 'The configuration file doesn\'t contain the sensitive data by security reason. The sensitive data can be stored in the next environment variables:
   * CONFIG__DEFAULT__CATALOG__PRODUCTALERT_CRON__ERROR_EMAIL for catalog/productalert_cron/error_email
   * CONFIG__DEFAULT__CATALOG__PRODUCT_VIDEO__YOUTUBE_API_KEY for catalog/product_video/youtube_api_key'
   */
  'system' => 
  array (
    'default' => 
    array (
      'general' => 
      array (
        'region' => 
        array (
          'display_all' => '1',
          'state_required' => 'AT,BR,CA,CH,EE,ES,FI,GB,LT,LV,MX,NL,RO,US',
        ),
      ),
      'catalog' => 
      array (
        'category' => 
        array (
          'root_id' => '2',
        ),
        'frontend' => 
        array (
          'list_allow_all' => '0',
          'flat_catalog_category' => '1',
          'flat_catalog_product' => '0',
        ),
        'productalert_cron' => 
        array (
          'frequency' => 'D',
          'time' => '00,00,00',
        ),
        'product_video' => 
        array (
        ),
        'price' => 
        array (
          'scope' => '0',
        ),
        'downloadable' => 
        array (
          'shareable' => '0',
          'content_disposition' => 'inline',
        ),
        'custom_options' => 
        array (
          'use_calendar' => '0',
          'year_range' => ',',
        ),
        'placeholder' => 
        array (
          'image_placeholder' => NULL,
          'small_image_placeholder' => NULL,
          'swatch_image_placeholder' => NULL,
          'thumbnail_placeholder' => NULL,
        ),
      ),
      'crontab' => 
      array (
        'default' => 
        array (
          'jobs' => 
          array (
            'catalog_product_alert' => 
            array (
              'schedule' => 
              array (
                'cron_expr' => '0 0 * * *',
              ),
              'run' => 
              array (
                'model' => NULL,
              ),
            ),
          ),
        ),
      ),
    ),
    'stores' => 
    array (
      'default' => 
      array (
        'design' => 
        array (
          'theme' => 
          array (
            'theme_id' => '4',
          ),
          'pagination' => 
          array (
            'pagination_frame_skip' => NULL,
            'anchor_text_for_previous' => NULL,
            'anchor_text_for_next' => NULL,
          ),
          'head' => 
          array (
            'title_prefix' => NULL,
            'title_suffix' => NULL,
            'includes' => NULL,
          ),
          'header' => 
          array (
            'logo_width' => NULL,
            'logo_height' => NULL,
          ),
          'footer' => 
          array (
            'absolute_footer' => NULL,
          ),
          'watermark' => 
          array (
            'image_size' => NULL,
            'image_imageOpacity' => NULL,
            'small_image_size' => NULL,
            'small_image_imageOpacity' => NULL,
            'thumbnail_size' => NULL,
            'thumbnail_imageOpacity' => NULL,
            'swatch_image_size' => NULL,
            'swatch_image_imageOpacity' => NULL,
          ),
          'email' => 
          array (
            'logo_alt' => NULL,
            'logo_width' => NULL,
            'logo_height' => NULL,
          ),
        ),
      ),
    ),
  ),
  'i18n' => 
  array (
  )
);
