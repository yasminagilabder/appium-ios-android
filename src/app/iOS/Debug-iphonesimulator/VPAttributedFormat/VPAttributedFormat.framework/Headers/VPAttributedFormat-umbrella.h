#ifdef __OBJC__
#import <UIKit/UIKit.h>
#else
#ifndef FOUNDATION_EXPORT
#if defined(__cplusplus)
#define FOUNDATION_EXPORT extern "C"
#else
#define FOUNDATION_EXPORT extern
#endif
#endif
#endif

#import "VPAttributedStringFormatter.h"
#import "VPAttributedTextControlHelper.h"
#import "VPConversionArgument.h"
#import "VPConversionSubstring.h"
#import "VPSpecifiersProvider.h"
#import "VPSubstring.h"
#import "VPSubstringsContainer.h"
#import "VPSubstring_Protected.h"
#import "VPValueWrapper.h"
#import "NSAttributedString+VPAttributedFormat.h"
#import "UIButton+VPAttributedFormat.h"
#import "UILabel+VPAttributedFormat.h"
#import "UITextField+VPAttributedFormat.h"
#import "UITextView+VPAttributedFormat.h"
#import "VPAttributedFormat.h"

FOUNDATION_EXPORT double VPAttributedFormatVersionNumber;
FOUNDATION_EXPORT const unsigned char VPAttributedFormatVersionString[];

